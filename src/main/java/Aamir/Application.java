package Aamir;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/2/24 10:47
 */

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//test springboot
@RestController
public class Application {
    @RequestMapping("/")
    @ResponseBody
    String helloAamir(){
        return "hello Aamir";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
