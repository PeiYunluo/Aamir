package Aamir.controller.user;

import Aamir.model.dto.QiniuImgDTO;
import Aamir.model.dto.Result;
import Aamir.model.enums.HttpStatus;
import Aamir.model.enums.UploadDIC;
import Aamir.service.AamirConfigService;
import Aamir.upload.QinniuUpload;
import Aamir.utils.AamirUtils;
import Aamir.utils.ResultGenerator;
import Aamir.utils.UploadFileUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


/**
 * @author peiyunluo@icloud.com
 * @date 2020/3/14 11:25
 */
@Controller
@RequestMapping("/Upload")
public class UploadController {
    @Autowired
    private AamirConfigService aamirConfigService;


    @GetMapping("/qiniu/getToken")
    @ApiOperation("get qiniu token")
    @ResponseBody
    public Result getToken(){
        String accessKey = aamirConfigService.findbynameadnfield("Qiniu","accessKey").getConfigvalue();
        String secretKey = aamirConfigService.findbynameadnfield("Qiniu","secretKey").getConfigvalue();
        String bucket= aamirConfigService.findbynameadnfield("Qiniu","bucket").getConfigvalue();

        QinniuUpload qinniuUpload = new QinniuUpload();
        QiniuImgDTO qiniuImgDTO = new QiniuImgDTO();
        qiniuImgDTO.setToken(qinniuUpload.getToken(accessKey,secretKey,bucket));
        long newMillis = System.currentTimeMillis();
        qiniuImgDTO.setKey(String.valueOf(newMillis));
        return ResultGenerator.getResultByHttp(HttpStatus.OK,qiniuImgDTO);
    }

    /**
     * @Description: 用户头像上传
     * @Param: [httpServletRequest, file]
     * @return: com.zhulin.blog.util.Result
     * @date: 2019/8/24 15:15
     */
    @PostMapping({"/upload/authorImg"})
    @ResponseBody
    public Result upload(HttpServletRequest httpServletRequest, @RequestParam("file") MultipartFile file) throws URISyntaxException {
        String suffixName = UploadFileUtils.getSuffixName(file);
        //生成文件名称通用方法
        String newFileName = UploadFileUtils.getNewFileName(suffixName);
        File fileDirectory = new File(UploadDIC.UPLOAD_AUTHOR_IMG);
        //创建文件
        File destFile = new File(UploadDIC.UPLOAD_AUTHOR_IMG + newFileName);
        try {
            if (!fileDirectory.exists()) {
                if (!fileDirectory.mkdirs()) {
                    throw new IOException("文件夹创建失败,路径为：" + fileDirectory);
                }
            }
            file.transferTo(destFile);
            Result resultSuccess = ResultGenerator.getResultByHttp(HttpStatus.OK);
            resultSuccess.setData(AamirUtils.getHost(new URI(httpServletRequest.getRequestURL() + ""))
                    + UploadDIC.SQL_AUTHOR_IMG + newFileName);
            return resultSuccess;
        } catch (IOException e) {
            e.printStackTrace();
            return ResultGenerator.getResultByHttp(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
