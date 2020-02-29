package Aamir.service.Impl;

import Aamir.repository.UserRepository;
import Aamir.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/2/29 9:43
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean validatePassword(Integer userId, String oldPwd) {
        return true;
    }

    @Override
    public String test() {
        return userRepository.findById(1).toString();
    }
}
