package Aamir.controller.items;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/3/18 8:01
 */
@Controller
@RequestMapping("/index")
public class IndexController {

    @RequestMapping("/index")
    public String index(HttpServletRequest request){
        return "index";
    }
}
