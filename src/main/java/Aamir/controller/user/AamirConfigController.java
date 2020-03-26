package Aamir.controller.user;

import Aamir.model.dto.Result;
import Aamir.model.entity.AamirConfig;
import Aamir.model.enums.HttpStatus;
import Aamir.service.AamirConfigService;
import Aamir.utils.ResultGenerator;
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
        return ResultGenerator.getResultByHttp(HttpStatus.OK,aamirConfigService.getAllOptions());
    }

    //TODO:最好整成params
    @PostMapping("/editOption")
    @ResponseBody
    @ApiOperation("edit option")
    public  Result editOption(@RequestBody AamirConfig aamirConfig){
        return ResultGenerator.getResultByHttp(HttpStatus.OK,aamirConfigService.modifyOptionbyid(aamirConfig));
    }

    //TODO:最好整成params
    @PostMapping("/findOption")
    @ResponseBody
    @ApiOperation("find option")
    public Result findOptionbyfieldandname(@RequestBody AamirConfig aamirConfig){
        return ResultGenerator.getResultByHttp(HttpStatus.OK,aamirConfigService.findbynameadnfield(aamirConfig.getConfigfield(),aamirConfig.getConfigname()));
    }

    @PostMapping("/switches")
    @ResponseBody
    public Result switches(@RequestBody AamirConfig aamirConfig){
        return ResultGenerator.getResultByHttp(HttpStatus.OK,aamirConfigService.switches(aamirConfig.getConfigfield(),aamirConfig.getConfigname()));
    }

}
