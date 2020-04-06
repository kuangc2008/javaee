package com.kc._200_springboot3;

import com.kc._200_springboot3.readinglist.ReaderHandlerMethodArgumentResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@SpringBootApplication
public class Application implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    //1 根目录转发到readingList
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addRedirectViewController("/", "/readingList");

//        registry.addViewController("/login").setViewName("login");
    }

    @Override
    public void addArgumentResolvers(
            List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new ReaderHandlerMethodArgumentResolver());
    }
}
