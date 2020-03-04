package Aamir.controller.user;

import Aamir.model.dto.Result;
import Aamir.model.enums.HttpStatus;
import Aamir.model.params.LoginParam;
import Aamir.service.UserService;
import Aamir.utils.ResultGenerator;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/2/29 9:50
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    //@ResponseBody
    @ApiOperation("login website")
    public String login() {
        return "adminLayui/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation("login")
    @ResponseBody
    public Result login(@RequestBody LoginParam loginParam) {
        String message = "hello Aamir";
        System.out.println(loginParam.toString());
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put(message, "helloAamir");
        if (StringUtils.isEmpty(loginParam.getUsername()) || StringUtils.isEmpty(loginParam.getPassword())) {
            return ResultGenerator.getResultByHttp(HttpStatus.BAD_REQUEST);
        }
        if (userService.validatePassword(loginParam.getUsername(), loginParam.getPassword())) {
//            session.setAttribute("loginUser", loginParam.getUsername());
//            session.setAttribute("loginUserId", loginParam.getPassword());
            return ResultGenerator.getResultByHttp(HttpStatus.OK, "/user/index");
        }
        return ResultGenerator.getResultByHttp(HttpStatus.UNAUTHORIZED);
    }


    @GetMapping("/index")
    public String index(HttpSession session) {
        return "adminLayui/index";
    }


    //    @ResponseBody
//    @PostMapping("/login")
//    public Boolean login(String username,String password){
//        return true;
//    }
/*
    @PostMapping("refresh/{refreshToken}")
    @ApiOperation("Refreshes token")
    @CacheLock(autoDelete = false)
    public AuthToken refresh(@PathVariable("refreshToken") String refreshToken) {
        return adminService.refreshToken(refreshToken);*/

   /* @PostMapping("login")
    @ApiOperation("Login")
    @CacheLock(autoDelete = false)
    public AuthToken auth(@RequestBody @Valid LoginParam loginParam) {
        return adminService.authenticate(loginParam);
    }*/


}
