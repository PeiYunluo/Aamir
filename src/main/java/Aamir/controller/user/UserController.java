package Aamir.controller.user;

import Aamir.exception.AamirException;
import Aamir.model.dto.Result;
import Aamir.model.enums.HttpStatus;
import Aamir.model.params.LoginParam;
import Aamir.service.UserService;
import Aamir.utils.JwtTokenUtil;
import Aamir.utils.ResultGenerator;
import io.jsonwebtoken.Claims;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
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
    @ApiOperation("login website")
    public String login() {
        return "adminLayui/login";
    }

    //TODO 过滤器 等
    @GetMapping("/test")
    @ApiOperation("login website")
    public String test() {
        return "views/index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation("login")
    @ResponseBody
    public Result<Map> login(@RequestBody LoginParam loginParam) {
        String message = "hello Aamir";
        System.out.println(loginParam.toString());
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put(message, "helloAamir");
        if (StringUtils.isEmpty(loginParam.getUsername()) || StringUtils.isEmpty(loginParam.getPassword())) {
            return ResultGenerator.getResultByHttp(HttpStatus.BAD_REQUEST);
        }
        if (userService.validatePassword(loginParam.getUsername(), loginParam.getPassword())) {
            Map<String, String> map = new HashMap<>();
            String token = new String(JwtTokenUtil.createJWT(loginParam.getUsername(), "admin", "thisissecretaudience"));
            System.out.println(token);
            map.put("token", token);
            map.put("address", "/user/index");

            return ResultGenerator.getResultByHttp(HttpStatus.OK, map);
        }
        return ResultGenerator.getResultByHttp(HttpStatus.UNAUTHORIZED);
    }

    @RequestMapping(value = "/logintoken", method = RequestMethod.POST)
    @ApiOperation("login")
    @ResponseBody
    public Result logintoken(@RequestBody LoginParam loginParam) {
        String message = "hello Aamir";
        System.out.println(loginParam.toString());
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put(message, "helloAamir");
        if (StringUtils.isEmpty(loginParam.getUsername()) || StringUtils.isEmpty(loginParam.getPassword())) {
            return ResultGenerator.getResultByHttp(HttpStatus.BAD_REQUEST);
        }
        if (userService.validatePassword(loginParam.getUsername(), loginParam.getPassword())) {
            return ResultGenerator.getResultByHttp(HttpStatus.OK, "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1ODM3MjM0NDcsInN1YiI6IntcIm5hbWVcIjpcIm5hbWVcIixcInVzZXJJZFwiOlwidXNlcmlkXCJ9IiwiaXNzIjoieGlleGllIiwiYXVkIjoiSGVsbG8gV29ybGQiLCJleHAiOjE1ODM4MDk4NDcsIm5iZiI6MTU4MzcyMzQ0N30.9fSB1Z-_MQ7j0XxQA9IDScSw-VEm6j5V8mRkuND364w");
        }
        return ResultGenerator.getResultByHttp(HttpStatus.UNAUTHORIZED);
    }

    @RequestMapping(value = "/getinfobytoken", method = RequestMethod.GET)
    @ApiOperation("get avstar name")
    @ResponseBody
    public Result<Map> getinfobytoken(@RequestParam String token) {
        Map<String, String> map = new HashMap<>();
        Result<Map> result = new Result<>();
        try {
            Claims parseToken = JwtTokenUtil.parseJWT(token);
            //map.put("name", parseToken.getSubject());
            System.out.println(parseToken.getSubject());
            map.put("name","admin");
            map.put("userId","admin");
            String[] ms = parseToken.getSubject().split(":");
            System.out.println(ms.toString());
            result.setResultCode(200);
            result.setMessage("success");
            result.setData(map);
        } catch (Exception e) {
            throw new AamirException("20000", "token错误，请重新登录");
        }
        return result;
    }


    @GetMapping("/index")
    public String index(HttpSession session) {
        return "adminLayui/index";
    }


    @GetMapping("/testexception")
    @ResponseBody
    public boolean testexception() {
        if (true) {
            throw new AamirException("400", "test！");
        }
        return true;
    }


}
