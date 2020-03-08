package Aamir.security;

import Aamir.exception.AamirException;
import Aamir.utils.JwtTokenUtil;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/3/7 17:55
 */
public class JwtInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String headerToken = request.getHeader("token");

        if (!request.getRequestURI().contains("login")) {
            if (headerToken == null || headerToken.length() == 0) {
                throw new AamirException("1000","无token，请重新登录");
            }
            else {
                try {
                    JwtTokenUtil.parseJWT(headerToken);
                    return true;
                }catch (Exception e){
                    throw new AamirException("1100","token错误，请重新登录");
                }
                }
            }
            //response.sendRedirect("login.do");
        return false;

        }
    }