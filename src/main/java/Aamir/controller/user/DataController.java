package Aamir.controller.user;

import Aamir.model.dto.Result;
import Aamir.model.entity.Category;
import Aamir.model.enums.HttpStatus;
import Aamir.service.*;
import Aamir.utils.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/3/22 10:31
 */
@Controller
@RequestMapping("/data")
public class DataController {
    @Autowired
    private AamirConfigService aamirConfigService;
    @Autowired
    private LinkService linkService;
    @Autowired
    private PostService postService;
    @Autowired
    private TagService tagService;
    @Autowired
    private PostCategoryService postCategoryService;
    @Autowired
    private CategroyService categroyService;
    @Autowired
    private PostTagService postTagService;
    @Autowired
    private CommentService commentService;


    @ResponseBody
    @GetMapping("/countsposts")
    public Result getthecountofposts(){
        return ResultGenerator.getResultByHttp(HttpStatus.OK,postService.getposts());
    }


    @ResponseBody
    @GetMapping("/countstags")
    public Result getthecountoftags(){
        return ResultGenerator.getResultByHttp(HttpStatus.OK,tagService.gettheounts());
    }


    @ResponseBody
    @GetMapping("/countscategories")
    public Result getthecountofcategories(){
        return ResultGenerator.getResultByHttp(HttpStatus.OK,categroyService.getcountsofcate());
    }

    @ResponseBody
    @GetMapping("/countsvisits")
    public Result getthecountofvisits(){
        return ResultGenerator.getResultByHttp(HttpStatus.OK,postService.getthecountofvisits());
    }
    @ResponseBody
    @GetMapping("/countsnotifications")
    public Result getthecountofnotifications(){
        return ResultGenerator.getResultByHttp(HttpStatus.OK,commentService.getNotificationscounts());
    }
}
