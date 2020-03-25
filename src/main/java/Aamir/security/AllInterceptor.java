package Aamir.security;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/3/25 17:55
 */
//AllInterceptor


import Aamir.exception.AamirException;
import Aamir.utils.JwtTokenUtil;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/3/7 17:55
 */
public class AllInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(request.getRequestURI());
        String method = request.getMethod();
        if (!method.equalsIgnoreCase("GET") && !method.equalsIgnoreCase("POST")){
            return true;
        }
        return true;
        //response.sendRedirect("login.do");
    }
}