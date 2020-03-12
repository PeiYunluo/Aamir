package Aamir.service.Impl;

import Aamir.model.entity.User;
import Aamir.repository.UserRepository;
import Aamir.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/2/29 9:43
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean validatePassword(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user.getPassword().equals(password))
        {
            return true;
        }
        return false;
    }

    @Override
    public String test() {
        return userRepository.findById(1).toString();
    }

    @Override
    public User getUser(Integer id) {
        return userRepository.findById(id).get();
    }
}
