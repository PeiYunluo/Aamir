package Aamir.model.params;

import lombok.Data;
import lombok.ToString;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/3/25 21:28
 */
@Data
@ToString
public class ForgotPWDParam {
    private String username;
    private String nickname;
    private String email;
}
