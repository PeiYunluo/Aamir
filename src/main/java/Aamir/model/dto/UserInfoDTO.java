package Aamir.model.dto;

import lombok.Data;
import lombok.ToString;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/3/22 13:50
 */
@Data
@ToString
public class UserInfoDTO {
    private Integer id;
    private String username;
    private String nickname;
    private String avatar;
    private String description;
    private String email;
}
