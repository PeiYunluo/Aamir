package Aamir.controller.user;

import Aamir.model.dto.AjaxResultPage;
import Aamir.model.dto.PostDTO;
import Aamir.model.dto.Result;
import Aamir.model.entity.Post;
import Aamir.model.params.PostListParam;
import Aamir.model.params.PostSaveParam;
import Aamir.service.*;
import Aamir.utils.CollectionUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/3/4 9:15
 */
@Controller
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;
    @Autowired
    private PostTagService postTagService;
    @Autowired
    private PostCategoryService postCategoryService;

    //TODO url重复的验证提示
    @ResponseBody
    @PostMapping("/create")
    @Transactional
    public Result savePost(@RequestBody PostSaveParam postSaveParam){
        Result result = new Result();
        if (ObjectUtils.isEmpty(postSaveParam)){
            result.setResultCode(501);
            result.setMessage("无任何内容");
            return result;
        }
        //维护post表
        Post post = postService.saveandupdatePost(postSaveParam);
        if (post!=null){
            Integer postid = post.getId();
            //维护posttag表
            List<Integer> tagsid = postSaveParam.getTagsid();
            if (!CollectionUtils.isEmpty(tagsid)){
                for (Integer tagid:tagsid
                     ) {
                    System.out.println(tagid);
                    postTagService.add(postid,tagid);
                }
                result.setMessage("tag增加完成");
            }
            //维护postcategory表
            List<Integer> categoriesid = postSaveParam.getCategoriesid();
            if (!CollectionUtils.isEmpty(categoriesid)){
                for (Integer categoryid:categoriesid
                     ) {
                    System.out.println(categoryid);
                    postCategoryService.add(postid,categoryid);
                }
                result.setMessage("cate and tag增加完成");
            }
            result.setResultCode(200);
            return result;
        }
        result.setResultCode(501);
        result.setMessage("未增加post tag category");
        return null;
    }


    @ResponseBody
    @GetMapping("/list")
    @ApiOperation("vue get post list paging")
    public AjaxResultPage<Post> getPostlist(PostListParam postListParam){
        Pageable pageable = PageRequest.of(postListParam.getPage() - 1, postListParam.getLimit());
        Page<Post> page = postService.getPosts(pageable);
        AjaxResultPage<Post> postAjaxResultPage = new AjaxResultPage<>();
        postAjaxResultPage.setData(page.getContent());
        postAjaxResultPage.setCount(page.getTotalPages());
        return postAjaxResultPage;
    }
}
