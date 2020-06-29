package com.atguigu.test;

import com.atguigu.aop.MathCalculator;
import com.atguigu.config.MainConfigOfAOP;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_Aop {


    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);
        MathCalculator calculator = applicationContext.getBean(MathCalculator.class);

//        1. 这个对象不要自己创建
//        MathCalculator newCalculator = new MathCalculator();
//        newCalculator.div(1,3);

        calculator.div(11,3);
        System.out.println("--------------------------");
        calculator.div(1,0);
        applicationContext.close();
    }
}
