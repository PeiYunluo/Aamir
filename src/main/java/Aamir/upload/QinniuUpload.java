package Aamir.upload;

import com.qiniu.util.Auth;
import io.micrometer.core.instrument.util.JsonUtils;
import lombok.Data;

import java.util.Date;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/3/14 11:08
 */
@Data
public class QinniuUpload {
/*    private  String accessKey = "wIXPYpseaztCxIJ5OGpTT42kE3AXrUS8w_dzjZrF";
    private  String secretKey = "VdTbn835V80PYk4vFNIu0LRYfEY_0Gyddgy8Ga_W";
    private  String bucket = "aamir-blog";*/

    public  String getToken(String accessKey,String secretKey,String bucket){
        long newMillis = System.currentTimeMillis();
        Date now = new Date(newMillis);
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        System.out.println(now);
        System.out.println(String.valueOf(newMillis));
        System.out.println(now.toString());
        System.out.println(upToken);
        return upToken;
    }


}
