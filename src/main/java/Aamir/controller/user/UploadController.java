package Aamir.controller.user;

import Aamir.model.dto.QiniuImgDTO;
import Aamir.model.dto.Result;
import Aamir.model.enums.HttpStatus;
import Aamir.upload.QinniuUpload;
import Aamir.utils.ResultGenerator;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



/**
 * @author peiyunluo@icloud.com
 * @date 2020/3/14 11:25
 */
@Controller
@RequestMapping("/Upload")
public class UploadController {
    @GetMapping("/qiniu/getToken")
    @ApiOperation("get qiniu token")
    @ResponseBody
    public Result getToken(){
        QinniuUpload qinniuUpload = new QinniuUpload();
        QiniuImgDTO qiniuImgDTO = new QiniuImgDTO();
        qiniuImgDTO.setToken(qinniuUpload.getToken());
        long newMillis = System.currentTimeMillis();
        qiniuImgDTO.setKey(String.valueOf(newMillis));
        return ResultGenerator.getResultByHttp(HttpStatus.OK,qiniuImgDTO);
    }
}
