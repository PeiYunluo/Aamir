package Aamir.model.params;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/3/2 9:40
 */
@Data
@ToString
public class LoginParam {

//    @NotBlank(message = "用户名或邮箱不能为空")
//    @Size(max = 255, message = "用户名或邮箱的字符长度不能超过 {max}")
    private String username;
//
//    @NotBlank(message = "登录密码不能为空")
//    @Size(max = 100, message = "用户密码字符长度不能超过 {max}")
    private String password;

}
