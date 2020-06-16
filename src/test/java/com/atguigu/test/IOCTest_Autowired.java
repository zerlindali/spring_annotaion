package com.atguigu.test;

import com.atguigu.config.MainConfigOfAutowired;
import com.atguigu.controller.BookController;
import com.atguigu.dao.BookDao;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_Autowired {
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);

    @Test
    public void test01(){
        applicationContext.getBean(BookController.class).printDao();
//        System.out.println(applicationContext.getBean(BookDao.class));
    }
}
