package Aamir.model.wechat;

import lombok.Data;
import lombok.ToString;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/3/26 9:37
 */
@Data
@ToString
public class WechatTokenParam {
    //client_credential
    private String grant_type;
    //wxe4e3b8dcb1ca8952
    private String appid;
    //21b8896b55f7db7cce1724c4fe00519f
    private String secret;
}
