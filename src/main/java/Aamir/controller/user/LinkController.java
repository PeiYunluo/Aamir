package Aamir.controller.user;

import Aamir.model.dto.Result;
import Aamir.model.entity.AamirConfig;
import Aamir.model.entity.Link;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/3/14 21:54
 */
@RequestMapping("/link")
@Controller
public class LinkController {


    @GetMapping("/getAlllinks")
    @ResponseBody
    @ApiOperation("get links list")
    public Result getAll(){
        return null;
    }

    @PostMapping("/editlink")
    @ResponseBody
    @ApiOperation("edit link")
    public Result editLink(@RequestBody Link link){
        return null;
    }

    @PostMapping("/addLink")
    @ResponseBody
    @ApiOperation("add link")
    public Result addLink(@RequestBody Link link){
        return null;
    }

    @PostMapping("/deleteLink")
    @ResponseBody
    @ApiOperation("delete link")
    public Result deleteLink(@RequestBody Link link){
        return null;
    }
}
