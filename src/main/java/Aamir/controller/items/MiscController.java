package Aamir.controller.items;

import Aamir.model.dto.CommentDTO;
import Aamir.model.dto.Result;
import Aamir.model.entity.Comment;
import Aamir.model.entity.Post;
import Aamir.model.entity.Tag;
import Aamir.model.enums.HttpStatus;
import Aamir.model.params.miscParams.CategoryPageParam;
import Aamir.model.params.miscParams.TagPageParam;
import Aamir.service.*;
import Aamir.utils.MarkdownUtils;
import Aamir.utils.PageUtils;
import Aamir.utils.ResultGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    private PostTagService postTagService;
    @Autowired
    private TagService tagService;
    @Autowired
    private PostService postService;



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


    @GetMapping("/getalltags")
    @ResponseBody
    public Result fetchAlltags(){
        return ResultGenerator.getResultByHttp(HttpStatus.OK,miscService.getAlltagsbydeleted());
    }

    @GetMapping("/getallcategories")
    @ResponseBody
    public Result fetchAllcategories(){
        return ResultGenerator.getResultByHttp(HttpStatus.OK,miscService.getAllcategoriesbydeleted());
    }

    @GetMapping("/getPostbyid")
    @ResponseBody
    public Result fetchOnePostbyid(Integer id){
        Post post = miscService.findPostbyid(id);
        post.setVisits(post.getVisits()+1);
        miscService.savenewvisit(post);
        if (post.getDeleted()!=true&&post.getStatus()==1){
            post.setOriginalContent(MarkdownUtils.mdToHtml(post.getOriginalContent()));
            return ResultGenerator.getResultByHttp(HttpStatus.OK,post);
        } else return ResultGenerator.getResultByHttp(HttpStatus.OK,"无此文章");

    }

    //TODO:考虑删除的情况 删除tag时自动将tagpost表置为删除
    //TODO:postcategory 置为删除
    //TODO:考虑同步状态
    @GetMapping("/getAlltagsbypostid")
    @ResponseBody
    public Result fetchAlltagsbypostid(Integer id){
        List<Integer> tagsid = postTagService.getTagsidbyid(id);

        List<Tag> newtags = new ArrayList<>();
        for (Integer tagid:tagsid
             ) {
          if (tagService.getTagbyid(tagid).getDeleted()!=true){
              newtags.add(tagService.getTagbyid(tagid));
          }
        }
        return ResultGenerator.getResultByHttp(HttpStatus.OK,newtags);
    }

    @GetMapping("/getAllposts")
    @ResponseBody
    public Result fetchAllposts(){
        List<Post> postList = miscService.getAllposts();
        List<Post> newpostList = new ArrayList<>();
        for (Post post:postList
             ) {
            if (post.getDeleted()!=true&&post.getStatus()==1)
            {
                newpostList.add(post);
            }
        }
        return ResultGenerator.getResultByHttp(HttpStatus.OK,newpostList);
    }
    //根据postid拿到所有评论内容
    //根据每个parentid 拿到reply列表
    @GetMapping("/getAllcomments")
    @ResponseBody
    public Result fetchAllcomments(Integer id){
        List<CommentDTO> commentDTOList = new ArrayList<>();
        List<Comment> commentList = miscService.getAllcommentsbypostid(id);
        for (Comment comment:commentList
             ) {
            CommentDTO commentDTO = new CommentDTO();
            commentDTO.setComment(comment);
            commentDTO.setReplycomments(miscService.getAllcommentsbypostidandparentid(id,comment.getId()));
            commentDTOList.add(commentDTO);
        }
        return ResultGenerator.getResultByHttp(HttpStatus.OK,commentDTOList);
    }


    //TODO:变成param
    @PostMapping("/addComment")
    @ResponseBody
    public Result addComment(@RequestBody Comment comment){
        if (miscService.addComment(comment)){
            return ResultGenerator.getResultByHttp(HttpStatus.OK,"增加成功");
        }
        return ResultGenerator.getResultByHttp(HttpStatus.BAD_REQUEST,"增加失败");
    }


    @GetMapping("/getAlllinks")
    @ResponseBody
    public Result fetchAlllinks(){
        return ResultGenerator.getResultByHttp(HttpStatus.OK,miscService.getAlllinks());
    }


    @GetMapping("/getOneComment")
    @ResponseBody
    public Result getOneComment(){
        return ResultGenerator.getResultByHttp(HttpStatus.OK,miscService.getOne());
    }

    @GetMapping("/getOnePost")
    @ResponseBody
    public Result getOnePost(){
        return ResultGenerator.getResultByHttp(HttpStatus.OK,miscService.getOnePost());
    }


}
