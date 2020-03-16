package Aamir.service.Impl;

import Aamir.model.entity.AamirConfig;
import Aamir.repository.AamirConfigRepository;
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

    @Autowired
    private AamirConfigRepository aamirConfigRepository;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    private JavaMailSenderImpl javaMailSender =new JavaMailSenderImpl();


    @Override
    public void sendSimpleEmail(String to, String subject, String content) {
        AamirConfig aamirConfighost = aamirConfigRepository.findByConfigfieldAndAndConfigname("QQMail","Host");
        AamirConfig aamirConfigname = aamirConfigRepository.findByConfigfieldAndAndConfigname("QQMail","Username");
        AamirConfig aamirConfigpassword = aamirConfigRepository.findByConfigfieldAndAndConfigname("QQMail","Password");
        AamirConfig aamirConfigencoding = aamirConfigRepository.findByConfigfieldAndAndConfigname("QQMail","DefaultEncoding");
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        javaMailSender.setHost(aamirConfighost.getConfigvalue());
        javaMailSender.setPassword(aamirConfigpassword.getConfigvalue());
        javaMailSender.setUsername(aamirConfigname.getConfigvalue());
        javaMailSender.setDefaultEncoding(aamirConfigencoding.getConfigvalue());
        simpleMailMessage.setFrom("Aamir-Blog" + "<" + aamirConfigname.getConfigvalue() + ">");
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
