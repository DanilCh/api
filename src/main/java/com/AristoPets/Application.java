package com.AristoPets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Arrays;


@SpringBootApplication
public class Application extends WebMvcConfigurerAdapter{
    public static void main(String args[])
    {
        ApplicationContext ctx = SpringApplication.run(Application.class,args);
    }

}
