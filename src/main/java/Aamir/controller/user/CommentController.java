package Aamir.controller.user;

import Aamir.model.dto.Result;
import Aamir.model.entity.AamirConfig;
import Aamir.model.entity.Comment;
import Aamir.model.enums.HttpStatus;
import Aamir.model.params.CommentPageParam;
import Aamir.model.params.PageParam;
import Aamir.service.CommentService;
import Aamir.utils.ResultGenerator;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/3/14 21:54
 */
@RequestMapping("/comment")
@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;


    @GetMapping("/getComments")
    @ResponseBody
    @ApiOperation("get comments list")
    public Result getAll(PageParam pageParam){
        Pageable pageable = PageRequest.of(pageParam.getPage() - 1, pageParam.getLimit());
        return ResultGenerator.getResultByHttp(HttpStatus.OK,commentService.getAllComents(pageable).getContent());
    }

    @GetMapping("/getCommentsbydeleted")
    @ResponseBody
    @ApiOperation("get comments list")
    public Result getCommentsbydeleted(CommentPageParam commentPageParam){
        Pageable pageable = PageRequest.of(commentPageParam.getPage() - 1, commentPageParam.getLimit());
        return ResultGenerator.getResultByHttp(HttpStatus.OK,commentService.getComments(commentPageParam.getDeleted(),pageable).getContent());
    }


    @GetMapping("/getCommentsbystatus")
    @ResponseBody
    @ApiOperation("get comments list")
    public Result getCommentsbystatus(CommentPageParam commentPageParam){
        Pageable pageable = PageRequest.of(commentPageParam.getPage() - 1, commentPageParam.getLimit());
        return ResultGenerator.getResultByHttp(HttpStatus.OK,commentService.getCommentsbystatus(commentPageParam.getStatus(),pageable).getContent());
    }

    @GetMapping("/getCommentsbynotification")
    @ResponseBody
    @ApiOperation("get comments list")
    public Result getCommentsbynotification(CommentPageParam commentPageParam){
        Pageable pageable = PageRequest.of(commentPageParam.getPage() - 1, commentPageParam.getLimit());
        return ResultGenerator.getResultByHttp(HttpStatus.OK,commentService.getCommentsbynotification(commentPageParam.getAllowNotification(),pageable).getContent());
    }

    @PostMapping("/addComment")
    @ResponseBody
    @ApiOperation("add comment")
    public  Result addComment(@RequestBody Comment comment){
        return ResultGenerator.getResultByHttp(HttpStatus.OK,commentService.addComment(comment));
    }

    @PostMapping("/switchnotificationbyid")
    @ResponseBody
    @ApiOperation("get comment")
    public Result switchnotification(@RequestBody Comment comment){
        return ResultGenerator.getResultByHttp(HttpStatus.OK,commentService.modifynotification(comment.getId()));
    }

    @PostMapping("/switchstatus")
    @ResponseBody
    @ApiOperation("get comment")
    public Result switchstatus(@RequestBody Comment comment){
        return ResultGenerator.getResultByHttp(HttpStatus.OK,commentService.modifystatus(comment.getId()));
    }

    @PostMapping("/deletecomment")
    @ResponseBody
    @ApiOperation("get comment")
    public Result deletecomment(@RequestBody Comment comment){
        return ResultGenerator.getResultByHttp(HttpStatus.OK,commentService.deleteCommentbyid(comment.getId()));
    }
}
