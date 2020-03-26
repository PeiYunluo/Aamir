package Aamir.model.wechat;

import lombok.Data;
import lombok.ToString;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/3/26 10:20
 */
@Data
@ToString
public class WechatTokenResponse {
    private String access_token;
    private String expires_in;
}
