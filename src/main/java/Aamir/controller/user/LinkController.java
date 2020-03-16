package Aamir.controller.user;

import Aamir.model.dto.Result;
import Aamir.model.entity.AamirConfig;
import Aamir.model.entity.Link;
import Aamir.model.enums.HttpStatus;
import Aamir.model.params.PageParam;
import Aamir.service.LinkService;
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
@RequestMapping("/link")
@Controller
public class LinkController {
    @Autowired
    private LinkService linkService;


    @GetMapping("/getAlllinks")
    @ResponseBody
    @ApiOperation("get links list")
    public Result getAll(PageParam pageParam){
        Pageable pageable = PageRequest.of(pageParam.getPage() - 1, pageParam.getLimit());
        //linkService.getLinks(pageable);
        return ResultGenerator.getResultByHttp(HttpStatus.OK,linkService.getLinks(pageable).getContent());
    }

    @PostMapping("/editlink")
    @ResponseBody
    @ApiOperation("edit link")
    public Result editLink(@RequestBody Link link){
        return ResultGenerator.getResultByHttp(HttpStatus.OK,linkService.updateLink(link));
    }

    @PostMapping("/addLink")
    @ResponseBody
    @ApiOperation("add link")
    public Result addLink(@RequestBody Link link){
        return ResultGenerator.getResultByHttp(HttpStatus.OK,linkService.addLink(link));
    }

    @PostMapping("/deleteLink")
    @ResponseBody
    @ApiOperation("delete link")
    public Result deleteLink(@RequestBody Link link){
        return ResultGenerator.getResultByHttp(HttpStatus.OK,linkService.deleteLinkbyid(link.getId()));
    }
}
