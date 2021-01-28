package com.sys.demo01.config;

import com.sys.demo01.interceptor.MyInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    //注册拦截器
    @Bean
    public MyInterceptor myInterceptor() {
        return new MyInterceptor();
    }

    ;
    //添加拦截器到连接器链


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor()).addPathPatterns("/*");

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	System.out.println("你好");
        //扫描static下的所有html页面
        registry.addResourceHandler("classpath:/static/*.html");
        //扫描static下的所有资源
        registry.addResourceHandler("/static/**");
    }
}
