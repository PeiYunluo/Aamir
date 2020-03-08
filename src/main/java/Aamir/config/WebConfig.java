package Aamir.config;

import Aamir.security.JwtInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/3/7 16:55
 */
@Configuration
@EnableWebMvc
//这个注解
public class WebConfig implements WebMvcConfigurer  {
    /**
     * 添加拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        System.out.println("addInterceptors");
        //拦截路径可自行配置多个 可用 ，分隔开
        registry.addInterceptor(new JwtInterceptor()).addPathPatterns("/tag/**","/category/**").excludePathPatterns("/user/**");
        //.excludePathPatterns("/X-admin/**","/favicon.ico")
        System.out.println("addInterceptors___________________)");
//        registry.addInterceptor(new JwtInterceptor()).excludePathPatterns("/user/login**");
    }
    /**
     * 跨域支持
     *
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT", "PATCH", "OPTIONS", "HEAD")
                .maxAge(3600 * 24);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    }
}