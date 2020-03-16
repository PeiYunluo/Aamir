package Aamir.config;

import Aamir.security.JwtInterceptor;
import com.google.common.eventbus.AsyncEventBus;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.config.annotation.*;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/3/7 16:55
 */
@Configuration
@EnableWebMvc

//这个注解
public class WebConfig implements WebMvcConfigurer {
    /**
     * 添加拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        System.out.println("addInterceptors");
        registry.addInterceptor(new JwtInterceptor())
                .addPathPatterns("/tag/**","/category/**","/link/**","/comment/**")
                .excludePathPatterns("/user/**","/comment/addComment");
        System.out.println("addInterceptors___________________)");
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

    /*@Bean
    @Scope("singleton")
    public AsyncEventBus asyncEventBus(){
        //创建线程池对象
        final ThreadPoolExecutor executor=executor();
        return new AsyncEventBus(executor);
    }
    //创建线程池方法
    private ThreadPoolExecutor executor(){
        return new
                ThreadPoolExecutor(2,
                2,0L,
                TimeUnit.MICROSECONDS,
                new LinkedBlockingQueue<>());
    }*/
    /*@Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(15);
        executor.setQueueCapacity(25);
        executor.initialize();
        return executor;
    }

    *//**
     * The {@link AsyncUncaughtExceptionHandler} instance to be used
     * when an exception is thrown during an asynchronous method execution
     * with {@code void} return type.
     *//*
    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }*/

}