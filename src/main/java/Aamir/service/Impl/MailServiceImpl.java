package Aamir.service.Impl;

import Aamir.service.MailService;
import cn.hutool.extra.mail.Mail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;



@Service
public class MailServiceImpl implements MailService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    private JavaMailSenderImpl javaMailSender =new JavaMailSenderImpl();


    @Override
    public void sendSimpleEmail(String to, String subject, String content) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        javaMailSender.setHost("smtp.qq.com");
        javaMailSender.setPassword("ysnoctwpglyybiai");
        javaMailSender.setUsername("229047180@qq.com");
        javaMailSender.setDefaultEncoding("UTF-8");
        simpleMailMessage.setFrom("peiyunluo" + "<" + "229047180@qq.com" + ">");
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(content);

        try{
            javaMailSender.send(simpleMailMessage);
            logger.info("简易邮件发送成功");
        } catch(Exception e) {
            logger.error("简易邮件发送异常", e);
        }

    }

}
