package Aamir.controller.user;

import Aamir.model.dto.AjaxPutPage;
import Aamir.model.dto.AjaxResultPage;
import Aamir.model.dto.Result;
import Aamir.model.entity.Tag;
import Aamir.model.enums.HttpStatus;
import Aamir.model.params.TaglistParam;
import Aamir.service.TagService;
import Aamir.utils.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/3/4 9:22
 */
@Controller
@RequestMapping("/tag")
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping("/taglist")
    public String gotoTag() {
        return "adminLayui/tag-list";
    }

    @ResponseBody
    @GetMapping("/getAlltags")
    public Result<Tag> tagsList() {
        //得到所有未经删除的tag
        List<Tag> list = tagService.getAlltags();
        for (Tag tag : list
        ) {
            if (tag.getDeleted())
                list.remove(tag);
        }
        return ResultGenerator.getResultByHttp(HttpStatus.OK, list);
    }

    /**
     * 标签分页
     *
     * @param ajaxPutPage
     * @param condition
     * @return com.site.blog.dto.AjaxResultPage<com.site.blog.entity.BlogTag>
     * @date 2019/9/1 11:20
     */
    @ResponseBody
    @GetMapping("/getAlltags/paging")
    //TODO:传入前台的数据可以只有id和name两项
    public AjaxResultPage<Tag> getCategoryList(AjaxPutPage<Tag> ajaxPutPage, Tag condition) {
        Pageable pageable = PageRequest.of(ajaxPutPage.getPage() - 1, ajaxPutPage.getLimit());
        Page<Tag> page = tagService.getTags(pageable);
        AjaxResultPage<Tag> result = new AjaxResultPage<>();
        result.setData(page.getContent());
        result.setCount(page.getTotalPages());
//        result.setCode(200);
//        result.setMsg("成功");
        return result;
    }

    @ResponseBody
    @PostMapping("/deleteTag")
    public Result deleteTag(Tag tag) {
        boolean flag = tagService.deleteTagbyid(tag.getId());
        if (flag) {
            return ResultGenerator.getResultByHttp(HttpStatus.OK);
        }
        return ResultGenerator.getResultByHttp(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //TODO 字段不可为空的提示
    @ResponseBody
    @PostMapping("/addTag")
    public Result addTag(Tag tag) {
        //tag.setCreateTime(DateUtils.getLocalCurrentDate());
        boolean flag = tagService.saveTag(tag);
        if (flag) {
            return ResultGenerator.getResultByHttp(HttpStatus.OK);
        } else {
            return ResultGenerator.getResultByHttp(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //TODO:分页方面  3条数据 2条一页只能显示1页

    @ResponseBody
    @PostMapping("/updateTagname")
    public Result updateTagname(Tag tag) {
        //tag.setCreateTime(DateUtils.getLocalCurrentDate());
        boolean flag = tagService.updateTagname(tag);
        if (flag) {
            return ResultGenerator.getResultByHttp(HttpStatus.OK);
        } else {
            return ResultGenerator.getResultByHttp(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //TODO search


    @ResponseBody
    @GetMapping("/list")
    //TODO:传入前台的数据可以只有id和name两项
    public AjaxResultPage<Tag> getTagList(TaglistParam taglistParam) {
        Pageable pageable = PageRequest.of(taglistParam.getPage() - 1, taglistParam.getLimit());
        Page<Tag> page = tagService.getTags(pageable);
        AjaxResultPage<Tag> result = new AjaxResultPage<>();
        result.setData(page.getContent());
        result.setCount(page.getTotalPages());
//        result.setCode(200);
//        result.setMsg("成功");
        return result;
    }


}
