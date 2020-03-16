package Aamir.service;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/3/15 10:51
 */
public interface MailService {
    void sendSimpleEmail(String to, String subject, String content);
}
