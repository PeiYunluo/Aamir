package Aamir.controller.user;

import Aamir.model.dto.AjaxResultPage;
import Aamir.model.dto.PostDTO;
import Aamir.model.dto.Result;
import Aamir.model.entity.Post;
import Aamir.model.enums.HttpStatus;
import Aamir.model.params.PostListParam;
import Aamir.model.params.PostSaveParam;
import Aamir.model.params.PostUpdateParam;
import Aamir.service.*;
import Aamir.utils.CollectionUtils;
import Aamir.utils.ResultGenerator;
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
            postTagService.deleteposttagbypostid(postSaveParam.getId());
            if (!CollectionUtils.isEmpty(tagsid)){
                for (Integer tagid:tagsid
                     ) {
                    //TODO:无法去除之前的标签
                    //TODO：根据postid删除所有posttag项目
                    System.out.println(tagid);
                    if (!postTagService.isexist(postid,tagid))
                        postTagService.add(postid,tagid);
                }
                result.setMessage("tag增加完成");
            }
            //维护postcategory表
            postCategoryService.deletePostCatebypostid(postSaveParam.getId());
            List<Integer> categoriesid = postSaveParam.getCategoriesid();
            if (!CollectionUtils.isEmpty(categoriesid)){
                for (Integer categoryid:categoriesid
                     ) {
                    System.out.println(categoryid);
                    if (!postCategoryService.isexist(postid,categoryid))
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

    @ResponseBody
    @GetMapping("/getPostbyid")
    @ApiOperation("vue get post by postid")
    public Result getPostbyid(Integer id){
        Post post = postService.getPostbyid(id);
        List<Integer> list1 = postTagService.getTagsidbyid(id);
        List<Integer> list2 = postCategoryService.getCategoriesidbyid(id);
        PostDTO postDTO = new PostDTO();
        postDTO.setId(post.getId());
        postDTO.setTitle(post.getTitle());
        postDTO.setStatus(post.getStatus());
        postDTO.setUrl(post.getUrl());
        postDTO.setOriginalContent(post.getOriginalContent());
        postDTO.setSummary(post.getSummary());
        postDTO.setDisallowComment(post.getDisallowComment());
        postDTO.setDeleted(post.getDeleted());
        postDTO.setTagsid(list1);
        postDTO.setCategoriesid(list2);
        return ResultGenerator.getResultByHttp(HttpStatus.OK,postDTO);
    }

    @ResponseBody
    @PostMapping("/delete")
    @ApiOperation("vue deleted")
    public Result deleteTag(@RequestBody Post post) {
        boolean flag = postService.deletePostbyid(post.getId());
        if (flag) {
            return ResultGenerator.getResultByHttp(HttpStatus.OK);
        }
        return ResultGenerator.getResultByHttp(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ResponseBody
    @PostMapping("/commentswitch")
    @ApiOperation("vue commentswitch")
    public Result switchComment(@RequestBody Post post) {
        boolean flag = postService.switchComment(post.getId());
        if (flag) {
            return ResultGenerator.getResultByHttp(HttpStatus.OK);
        }
        return ResultGenerator.getResultByHttp(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ResponseBody
    @PostMapping("/gettagsbyid")
    @ApiOperation("vue get all tags by id")
    public Result getTagsbyid(@RequestBody Post post){
        List<Integer> list = postTagService.getTagsidbyid(post.getId());
        Result<List> result =new Result<>();
        result.setData(list);
        result.setMessage("ok");
        result.setResultCode(200);
        return result;
    }

    @ResponseBody
    @PostMapping("/getcategoriesbyid")
    @ApiOperation("vue get all tags by id")
    public Result getCategoriesbyid(@RequestBody Post post){
        List<Integer> list = postCategoryService.getCategoriesidbyid(post.getId());
        Result<List> result =new Result<>();
        result.setData(list);
        result.setMessage("ok");
        result.setResultCode(200);
        return result;
    }

    @ResponseBody
    @PostMapping("/updatePost")
    @ApiOperation("vue update post")
    public Result updatePost(@RequestBody  PostUpdateParam postUpdateParam){
        Result result = new Result();
        Post post = postService.updatePost(postUpdateParam);
        if (post!=null){
            Integer postid = post.getId();
            //维护posttag表
            List<Integer> tagsid = postUpdateParam.getTagsid();
            if (!CollectionUtils.isEmpty(tagsid)){
                for (Integer tagid:tagsid
                ) {
                    System.out.println(tagid);
                    if (!postTagService.isexist(postid,tagid))
                    postTagService.add(postid,tagid);
                }
                result.setMessage("tag增加完成");
            }
            //维护postcategory表
            List<Integer> categoriesid = postUpdateParam.getCategoriesid();
            if (!CollectionUtils.isEmpty(categoriesid)){
                for (Integer categoryid:categoriesid
                ) {
                    System.out.println(categoryid);
                    if (!postCategoryService.isexist(postid,categoryid))
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
    @PostMapping("/statusswitch")
    @ApiOperation("vue change status")
    public Result statusswitch(@RequestBody Post post){

        if (postService.switchstatus(post.getId())){
            return ResultGenerator.getResultByHttp(HttpStatus.OK);
        }
        return ResultGenerator.getResultByHttp(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
