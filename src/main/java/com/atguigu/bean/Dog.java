package com.atguigu.bean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Dog implements ApplicationContextAware {

    ApplicationContext applicationContext;

    public Dog() {
        System.out.println("dog constructor......");
    }

    // 对象创建并赋值之后调用
    @PostConstruct
    public void init(){
        System.out.println("Dog....construct......");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Dog.....destroy.....");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
