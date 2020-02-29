package Aamir.service;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/2/29 9:43
 */
public interface UserService {
    boolean validatePassword(Integer userId,String oldPwd);
    String test();
}
