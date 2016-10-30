package com.AristoPets.Hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;


@SpringBootApplication
public class Application {
    public static void main(String args[])
    {
        ApplicationContext ctx = SpringApplication.run(Application.class,args);

        System.out.println("V primere zdez smotreli Beans");

        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for(String name : beanNames)
        {
            System.out.println(name);
        }
    }
}
