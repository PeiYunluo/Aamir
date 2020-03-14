package Aamir.controller.user;

import Aamir.model.dto.QiniuImgDTO;
import Aamir.model.dto.Result;
import Aamir.model.entity.Photo;
import Aamir.model.enums.HttpStatus;
import Aamir.service.PhotoService;
import Aamir.upload.QinniuUpload;
import Aamir.utils.ResultGenerator;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/3/14 15:59
 */
@RequestMapping("/photo")
@Controller
public class PhotoController {
    @Autowired
    private PhotoService photoService;

    @GetMapping("/qiniu/getToken")
    @ApiOperation("get qiniu token")
    @ResponseBody
    public Result getToken(){
        QinniuUpload qinniuUpload = new QinniuUpload();
        QiniuImgDTO qiniuImgDTO = new QiniuImgDTO();
        qiniuImgDTO.setToken(qinniuUpload.getToken());
        long newMillis = System.currentTimeMillis();
        qiniuImgDTO.setKey(String.valueOf(newMillis));
        Photo photo = new Photo();
        photo.setUrl(String.valueOf(newMillis));
        if (photoService.savePhoto(photo))
        return ResultGenerator.getResultByHttp(HttpStatus.OK,qiniuImgDTO);
        return ResultGenerator.getResultByHttp(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/qiniu/getAllphotos")
    @ApiOperation("get qiniu token")
    @ResponseBody
    public Result getAllphotos(){
        return ResultGenerator.getResultByHttp(HttpStatus.OK,photoService.getAllPhotosurl());
    }
}
