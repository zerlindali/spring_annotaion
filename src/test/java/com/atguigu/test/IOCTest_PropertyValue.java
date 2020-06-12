package com.atguigu.test;

import com.atguigu.bean.Person;
import com.atguigu.config.MainConfigOfPropertyVaules;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Arrays;

public class IOCTest_PropertyValue {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfPropertyVaules.class);

    @Test
    public void test01() {
        printBeans(context);
        System.out.println("=======================");
        Person person = (Person)context.getBean("person");
        System.out.println(person);

        ConfigurableEnvironment environment = context.getEnvironment();
        String property = environment.getProperty("person.nickName");
        System.out.println(property);

        context.close();
    }

    private void printBeans(AnnotationConfigApplicationContext applicationContext){
        String[] names = applicationContext.getBeanDefinitionNames();
        Arrays.asList(names).stream().forEach(x->System.out.println(x));
    }
}
