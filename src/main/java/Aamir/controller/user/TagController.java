package Aamir.controller.user;

import Aamir.model.dto.AjaxPutPage;
import Aamir.model.dto.AjaxResultPage;
import Aamir.model.dto.Result;
import Aamir.model.entity.Tag;
import Aamir.model.enums.HttpStatus;
import Aamir.service.TagService;
import Aamir.utils.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
    public String gotoTag(){
        return "adminLayui/tag-list";
    }

    @ResponseBody
    @GetMapping("/getAlltags")
    public Result<Tag> tagsList(){
//        QueryWrapper<Tag> queryWrapper = new QueryWrapper<Tag>();
//        queryWrapper.lambda().eq(Tag::getIsDeleted, PostStatus.ZERO);
//        List<Tag> list = blogTagService.list(queryWrapper);
       List<Tag> list = tagService.getAlltags();
        return ResultGenerator.getResultByHttp(HttpStatus.OK,list);
    }
    /**
     * 标签分页
     * @param ajaxPutPage
     * @param condition
     * @return com.site.blog.dto.AjaxResultPage<com.site.blog.entity.BlogTag>
     * @date 2019/9/1 11:20
     */
    @ResponseBody
    @GetMapping("/getAlltags/paging")
    public AjaxResultPage<Tag> getCategoryList(AjaxPutPage<Tag> ajaxPutPage, Tag condition){
        Pageable pageable = PageRequest.of(ajaxPutPage.getPage() - 1, ajaxPutPage.getLimit());
        Page<Tag> page = tagService.getTags(pageable);
        AjaxResultPage<Tag> result = new AjaxResultPage<>();
        result.setData(page.getContent());
        result.setCount(page.getTotalPages());
//        result.setCode(200);
//        result.setMsg("成功");
        return result;
    }
}
