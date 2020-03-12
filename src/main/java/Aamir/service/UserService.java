package Aamir.service;

import Aamir.model.entity.User;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/2/29 9:43
 */
public interface UserService {
    boolean validatePassword(String userId,String oldPwd);
    User getUser(Integer id);
    String test();
}
