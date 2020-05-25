package Aamir.service;

import Aamir.model.entity.User;
import Aamir.model.params.ForgotPWDParam;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/2/29 9:43
 */
public interface UserService {
    boolean validatePassword(String userId,String oldPwd);
    User getUser(Integer id);
    Boolean updateUser(User user);
    String test();
    Boolean modifyPassword(String userId,String newPwd);
    Boolean forgotPassword(ForgotPWDParam forgotPWDParam);
    User getUserBy(String username,String nickname,String email);
    User initUser(User user);
}
