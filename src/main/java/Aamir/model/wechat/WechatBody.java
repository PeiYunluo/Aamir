package Aamir.model.wechat;

import lombok.Data;
import lombok.ToString;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/3/26 9:36
 */
@Data
@ToString
public class WechatBody {

    //带一个param access_token
    //oBxbhwQZSHRCQer0guvmXgwLRBhE
    private String touser;
    //7uqUOFTP81nzG35-fO1pD70gXBapsHjx1nHvvhC54kU
    private String template_id;
}
