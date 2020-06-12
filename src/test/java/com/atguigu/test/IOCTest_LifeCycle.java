package com.atguigu.test;

import com.atguigu.bean.Cat;
import com.atguigu.config.MainConfigOfLifeCycle;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_LifeCycle {

    private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);

    @Autowired
    Cat cat;

    @Test
    public void test(){
        // 容器创建完成
        System.out.println("容器创建完成....");
        context.getBean("car");
        context.getBean("dog");
        context.close();
    }

    @Test
    public void test02(){
        System.out.println(cat);

    }
}
