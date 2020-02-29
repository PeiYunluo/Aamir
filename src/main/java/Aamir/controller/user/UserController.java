package Aamir.controller.user;

import Aamir.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/2/29 9:50
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("/login")
    @ResponseBody
    public String login() {

        return userService.test();
    }

//    @ResponseBody
//    @PostMapping("/login")
//    public Boolean login(String username,String password){
//        return true;
//    }
}
