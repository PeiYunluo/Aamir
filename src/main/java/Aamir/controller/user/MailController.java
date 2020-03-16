package Aamir.controller.user;

import Aamir.service.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/3/15 11:02
 */
@RequestMapping("/mail")
@Controller
public class MailController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    MailService mailService;

    @GetMapping("/sendmail")
    @ResponseBody
    @Async
    public void sendSimpleEmail()  {
        try {
            mailService.sendSimpleEmail("peiyunluo@icloud.com", "测试邮件题目", "测试邮件内容");
        } catch(Exception e){
            logger.info("Controller异常");
        }
    }


}
