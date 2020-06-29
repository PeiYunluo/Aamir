package Aamir.controller.user;

import Aamir.model.dto.QiniuImgDTO;
import Aamir.model.dto.Result;
import Aamir.model.entity.Photo;
import Aamir.model.enums.HttpStatus;
import Aamir.service.AamirConfigService;
import Aamir.service.PhotoService;
import Aamir.upload.AliUpload;
import Aamir.upload.QinniuUpload;
import Aamir.utils.ResultGenerator;
import Aamir.utils.UploadFileUtils;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/3/14 15:59
 */
@RequestMapping("/photo")
@Controller
public class PhotoController {
    @Autowired
    private PhotoService photoService;
    @Autowired
    private AamirConfigService aamirConfigService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @GetMapping("/qiniu/getToken")
    @ApiOperation("get qiniu token")
    @ResponseBody
    public Result getToken() {
        String accessKey = aamirConfigService.findbynameadnfield("Qiniu", "accessKey").getConfigvalue();
        String secretKey = aamirConfigService.findbynameadnfield("Qiniu", "secretKey").getConfigvalue();
        String bucket = aamirConfigService.findbynameadnfield("Qiniu", "bucket").getConfigvalue();
        QinniuUpload qinniuUpload = new QinniuUpload();
        QiniuImgDTO qiniuImgDTO = new QiniuImgDTO();
        qiniuImgDTO.setToken(qinniuUpload.getToken(accessKey, secretKey, bucket));
        long newMillis = System.currentTimeMillis();
        qiniuImgDTO.setKey(String.valueOf(newMillis));
        Photo photo = new Photo();
        photo.setUrl(String.valueOf(newMillis));
        if (photoService.savePhoto(photo))
            return ResultGenerator.getResultByHttp(HttpStatus.OK, qiniuImgDTO);
        return ResultGenerator.getResultByHttp(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/qiniu/getAllphotos")
    @ApiOperation("get qiniu token")
    @ResponseBody
    public Result getAllphotos() {
        return ResultGenerator.getResultByHttp(HttpStatus.OK, photoService.getAllPhotosurl());
    }

    @GetMapping("/AliOss/getAllAliOssphotos")
    @ApiOperation("get qiniu token")
    @ResponseBody
    public Result getAllAliOssphotos() {
        return ResultGenerator.getResultByHttp(HttpStatus.OK, photoService.getAllAliOssPhotosurl());
    }

    @GetMapping("/qiniu/getAlllocalphotos")
    @ApiOperation("get qiniu token")
    @ResponseBody
    public Result getAlllocalphotos() {
        return ResultGenerator.getResultByHttp(HttpStatus.OK, photoService.getAllPhotosLocalurl());
    }

    @PostMapping("/uploadFile")
    @ResponseBody
    public Result uploadFile(MultipartFile file) {
        //图片写在磁盘D盘
        String path = "d://uploadFiles/";
//        String path = "/uploadFiles/";
        if (file.isEmpty()) {
            return ResultGenerator.getResultByHttp(HttpStatus.BAD_REQUEST, "文件不能为空");
        }
        String fileName = file.getOriginalFilename();
        logger.info("上传的文件名为：" + fileName);
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        logger.info("上传的后缀名为：" + suffixName);

        String filePath = path;
        String fileUrl = UploadFileUtils.getNewFileName(suffixName);
        File dest = new File(filePath + fileUrl);
        System.out.println(dest.getAbsolutePath());
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            logger.info("上传成功后的文件路径未：" + filePath + fileName);
            Photo photo = new Photo();
            //photo.setUrl(String.valueOf(filePath + UploadFileUtils.getNewFileName(suffixName)));
            photo.setLocalurl(fileUrl);
            photo.setName(fileName);
            photoService.savePhoto(photo);
            return ResultGenerator.getResultByHttp(HttpStatus.OK, filePath + fileName);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResultGenerator.getResultByHttp(HttpStatus.BAD_REQUEST, "错误");
    }

    @PostMapping("/uploadmarkdown")
    @ResponseBody
    public Result uploadMarkdown(MultipartFile file) {
        //图片写在磁盘D盘
        //TODO
        String path = "d://uploadFiles/Markdown/";
//        String path = "/uploadFiles/Markdown/";
        if (file.isEmpty()) {
            return ResultGenerator.getResultByHttp(HttpStatus.BAD_REQUEST, "文件不能为空");
        }
        String fileName = file.getOriginalFilename();
        logger.info("上传的文件名为：" + fileName);
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        logger.info("上传的后缀名为：" + suffixName);

        String filePath = path;
        String fileUrl = UploadFileUtils.getNewFileName(suffixName);
        File dest = new File(filePath + fileUrl);
        System.out.println(dest.getAbsolutePath());
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            System.out.println(file.getInputStream().toString());
            byte[] bytes = new byte[0];
            bytes = new byte[file.getInputStream().available()];
            file.getInputStream().read(bytes);
            String str = new String(bytes);
            file.transferTo(dest);
            System.out.println(str);
            logger.info("上传成功后的文件路径为：" + filePath + fileName);
            return ResultGenerator.getResultByHttp(HttpStatus.OK, str);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResultGenerator.getResultByHttp(HttpStatus.BAD_REQUEST, "错误");
    }

    @GetMapping("/AliOss/getToken")
    @ApiOperation("get token")
    @ResponseBody
    public Result getAliOSSToken() {
        AliUpload aliUpload = new AliUpload();
        //aliUpload.getAliOSSToken();
        return ResultGenerator.getResultByHttp(HttpStatus.OK, "sucesss");
    }

    @PostMapping("/uploadAliOss")
    @ResponseBody
    public Result uploadAliOss(MultipartFile file) {
        AliUpload aliUpload = new AliUpload();
        String accessKey = aamirConfigService.findbynameadnfield("AliOss", "accessKey").getConfigvalue();
        String accessSecret = aamirConfigService.findbynameadnfield("AliOss", "secretKey").getConfigvalue();
        String bucketName = aamirConfigService.findbynameadnfield("AliOss", "bucket").getConfigvalue();
        String endPoint = aamirConfigService.findbynameadnfield("AliOss", "endPoint").getConfigvalue();
        long newMillis = System.currentTimeMillis();
        Date now = new Date(newMillis);
        String fileName = String.valueOf(newMillis);
        aliUpload.upload(file, endPoint, accessKey, accessSecret, bucketName, fileName);
        Photo photo = new Photo();
        photo.setUrl(fileName);
        photo.setDescription("AliOss");
        photoService.savePhoto(photo);
        return ResultGenerator.getResultByHttp(HttpStatus.OK, "sucesss");
    }
}
