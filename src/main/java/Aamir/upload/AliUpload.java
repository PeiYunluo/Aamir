package Aamir.upload;

import Aamir.exception.AamirException;
import Aamir.model.dto.UploadResult;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.DeleteObjectsRequest;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageReader;
import java.io.IOException;
import java.util.Date;
import java.util.Objects;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/4/8 21:49
 */
@Data
//public class AliUpload {
//    public String getAliOSSToken(){
//        // Endpoint以杭州为例，其它Region请按实际情况填写。
//        String endpoint = "http://oss-cn-beijing.aliyuncs.com";
//            // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
//        String accessKeyId = "LTAI4FwsawGztoR3AyifiGfj";
//        String accessKeySecret = "Zgqdi3rT5oZGkSnKqMe0Oonxobz8cj";
//        String securityToken = "<yourSecurityToken>";
//
//            // 用户拿到STS临时凭证后，通过其中的安全令牌（SecurityToken）和临时访问密钥（AccessKeyId和AccessKeySecret）生成OSSClient。
//            // 创建OSSClient实例。
//        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
//            // OSS相关操作。例如上传、下载文件等。
//            // 上传文件。
//            // ossClient.putObject(putObjectRequest);
//            // 下载OSS文件到本地文件。如果指定的本地文件存在会覆盖，不存在则新建。
//            // ossClient.getObject(new GetObjectRequest(bucketName, objectName), new File("<yourLocalFile>"));
//            // 关闭OSSClient。
//        ossClient.shutdown();
//        return "sucess";
//    }
//}
public class AliUpload {
    public UploadResult upload(MultipartFile file,String endPoint,String accessKey,String accessSecret,String bucketName,String fileName) {
        Assert.notNull(file, "Multipart file must not be null");
        // Get config
        // Init OSS client
        OSS ossClient = new OSSClientBuilder().build(endPoint, accessKey, accessSecret);
        StringBuilder basePath = new StringBuilder("https://");
        try {
            //filename
            PutObjectResult putObjectResult = ossClient.putObject(bucketName, fileName, file.getInputStream());
            if (putObjectResult == null) {
                throw new AamirException("内部错误","内部错误");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
           return null;
    }


   /* public void delete(String key) {
        Assert.notNull(key, "File key must not be blank");

        // Get config
        String endPoint = optionService.getByPropertyOfNonNull(AliOssProperties.OSS_ENDPOINT).toString();
        String accessKey = optionService.getByPropertyOfNonNull(AliOssProperties.OSS_ACCESS_KEY).toString();
        String accessSecret = optionService.getByPropertyOfNonNull(AliOssProperties.OSS_ACCESS_SECRET).toString();
        String bucketName = optionService.getByPropertyOfNonNull(AliOssProperties.OSS_BUCKET_NAME).toString();

        // Init OSS client
        OSS ossClient = new OSSClientBuilder().build(endPoint, accessKey, accessSecret);

        try {
            ossClient.deleteObject(new DeleteObjectsRequest(bucketName).withKey(key));
        } catch (Exception e) {
            throw new FileOperationException("附件 " + key + " 从阿里云删除失败", e);
        } finally {
            ossClient.shutdown();
        }
    }

    @Override
    public AttachmentType getAttachmentType() {
        return AttachmentType.ALIOSS;
    }*/

}

