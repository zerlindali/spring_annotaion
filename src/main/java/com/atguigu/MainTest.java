package com.atguigu;

import com.atguigu.bean.Person;
import com.atguigu.config.MainConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * @author ZerlindaLi create at 2020/5/27 11:14
 * @version 1.0.0
 * @description MainTest
 */
public class MainTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Person bean = applicationContext.getBean(Person.class);
        System.out.println(bean);

        String[] names = applicationContext.getBeanNamesForType(Person.class);
        System.out.println(Arrays.asList(names));

        Person bean2 = (Person)applicationContext.getBean("person");
        System.out.println(bean2);





    }
}
