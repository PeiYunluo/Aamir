package Aamir.controller.user;

import Aamir.model.dto.Result;
import Aamir.model.entity.AamirConfig;
import Aamir.model.entity.Comment;
import Aamir.model.params.CommentPageParam;
import Aamir.model.params.PageParam;
import io.swagger.annotations.ApiOperation;
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
    @GetMapping("/getComments")
    @ResponseBody
    @ApiOperation("get comments list")
    public Result getAll(PageParam pageParam){
        Pageable pageable = PageRequest.of(pageParam.getPage() - 1, pageParam.getLimit());
        return null;
    }

    @PostMapping("/addComment")
    @ResponseBody
    @ApiOperation("add comment")
    public  Result addComment(@RequestBody Comment comment){
        return null;
    }

    @PostMapping("/getCommentbyid")
    @ResponseBody
    @ApiOperation("get comment")
    public Result getAllbyid(CommentPageParam commentPageParam){
        return null;
    }

}
