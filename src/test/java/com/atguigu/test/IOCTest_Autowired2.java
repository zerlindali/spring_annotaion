package com.atguigu.test;

import com.atguigu.bean.Boss;
import com.atguigu.bean.Car;
import com.atguigu.bean.Color;
import com.atguigu.bean.Red;
import com.atguigu.config.MainConfigOfAutowired2;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author ZerlindaLi create at 2020/6/15 11:36
 * @version 1.0.0
 * @description IOCTest_Autowired2
 */
public class IOCTest_Autowired2 {

    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAutowired2.class);

    @Test
    public void test01(){
        Boss boss = applicationContext.getBean(Boss.class);
        System.out.println(boss);

        Color color = applicationContext.getBean(Color.class);

        Car car = applicationContext.getBean(Car.class);
        System.out.println(car == boss.getCar());
        System.out.println(boss.getCar() == color.getCar());
        System.out.println(car == color.getCar());

        applicationContext.close();
    }

    @Test
    public void test02(){
        Red red = applicationContext.getBean(Red.class);
        System.out.println(applicationContext);
        applicationContext.close();
    }
}
