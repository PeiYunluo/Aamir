package Aamir.security;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/3/7 9:48
 */
@Data
@Component
@ConfigurationProperties(prefix = "audience")
public class Audience {
    private String clientId;
    private String base64Secret;
    private String name;
    private int expiresSecond;
}