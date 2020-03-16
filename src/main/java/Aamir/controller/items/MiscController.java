package Aamir.controller.items;

import Aamir.model.dto.Result;
import Aamir.model.entity.Post;
import Aamir.model.entity.PostCategory;
import Aamir.model.entity.Tag;
import Aamir.model.enums.HttpStatus;
import Aamir.model.params.miscParams.CategoryPageParam;
import Aamir.model.params.miscParams.TagPageParam;
import Aamir.service.*;
import Aamir.utils.PageUtils;
import Aamir.utils.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/3/16 13:49
 */
@RequestMapping("/misc")
@Controller
public class MiscController {

    @Autowired
    private MiscService miscService;


    @GetMapping("/fetchAllpostsBytagid")
    @ResponseBody
    public Result fetchAllpostsBytagid(TagPageParam tagPageParam){
        Pageable pageable = PageRequest.of(tagPageParam.getPage() - 1, tagPageParam.getLimit());
        List<Integer> integerList = miscService.findallpostsbytagid(tagPageParam.getId());
        List<Post> list = miscService.getAllpostsbypostid(integerList,pageable);
        //去除已删除
        List<Post> newlist = new ArrayList<>();
        for (Post post:list
             ) {
            if (post.getDeleted()==true||post.getStatus()==0){

            }else newlist.add(post);
        }
        Page<Post> postPage = PageUtils.listConvertToPage(newlist,pageable);
        return ResultGenerator.getResultByHttp(HttpStatus.OK,postPage.getContent());
    }


    @GetMapping("/fetchAllpostsBycategoryid")
    @ResponseBody
    public Result fetchAllpostsBycategoryid(CategoryPageParam categoryPageParam){
        Pageable pageable = PageRequest.of(categoryPageParam.getPage() - 1, categoryPageParam.getLimit());
        List<Integer> integerList = miscService.findallpostsbycategoryid(categoryPageParam.getId());
        List<Post> list =miscService.getAllpostsbypostid(integerList,pageable);
        List<Post> newlist = new ArrayList<>();
        for (Post post:list
        ) {
            if (post.getDeleted()==true||post.getStatus()==0){

            }else newlist.add(post);
        }
        Page<Post> postPage = PageUtils.listConvertToPage(newlist,pageable);
        return ResultGenerator.getResultByHttp(HttpStatus.OK,postPage.getContent());
    }





}
