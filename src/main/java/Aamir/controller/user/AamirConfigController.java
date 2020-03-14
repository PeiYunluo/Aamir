package Aamir.controller.user;

import Aamir.model.dto.Result;
import Aamir.model.entity.AamirConfig;
import Aamir.service.AamirConfigService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/3/14 21:54
 */
@RequestMapping("/aamirconfig")
@Controller
public class AamirConfigController {
    @Autowired
    private AamirConfigService aamirConfigService;

    @GetMapping("/getAlloptions")
    @ResponseBody
    @ApiOperation("get options list")
    public Result getAll(){
        return null;
    }

    @PostMapping("/editOption")
    @ResponseBody
    @ApiOperation("edit option")
    public  Result editOption(@RequestBody AamirConfig aamirConfig){
        return null;
    }

    @PostMapping("/addOption")
    @ResponseBody
    @ApiOperation("add option")
    public  Result addOption(@RequestBody AamirConfig aamirConfig){
        return null;
    }
}
