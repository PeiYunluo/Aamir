package Aamir.service.Impl;

import Aamir.model.entity.User;
import Aamir.model.params.ForgotPWDParam;
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

    @Override
    public Boolean updateUser(User user) {
        User olduser = userRepository.findByUsername(user.getUsername());
        user.setPassword(olduser.getPassword());
        if (userRepository.saveAndFlush(user)!=null){
            return true;
        }
        return false;
    }

    @Override
    public Boolean modifyPassword(String userId, String newPwd) {
        User olduser = userRepository.findByUsername(userId);
        olduser.setPassword(newPwd);
        if (userRepository.saveAndFlush(olduser)!=null){
            return true;
        }
        return false;
    }

    @Override
    public Boolean forgotPassword(ForgotPWDParam forgotPWDParam) {
        if (userRepository.existsByUsernameAndNicknameAndEmail(forgotPWDParam.getUsername(),forgotPWDParam.getNickname(),forgotPWDParam.getEmail())){
            return true;
        }
        return false;
    }

    @Override
    public User getUserBy(String username, String nickname, String email) {
        return userRepository.findByUsernameAndNicknameAndEmail(username,nickname,email);
    }

    @Override
    public User initUser(User user) {
        if (userRepository.existsById(1)){
            userRepository.deleteById(1);
        }
        user.setId(1);
        return userRepository.saveAndFlush(user);
    }
}
