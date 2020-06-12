package com.atguigu.test;

import com.atguigu.bean.Car;
import com.atguigu.bean.ColorFactoryBean;
import com.atguigu.bean.Hair;
import com.atguigu.bean.Person;
import com.atguigu.config.MainConfig;
import com.atguigu.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Arrays;
import java.util.Map;

/**
 * @author ZerlindaLi create at 2020/5/27 14:33
 * @version 1.0.0
 * @description IOCTest
 */
public class IOCTest {

    @Test
    public void test(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String [] names = annotationConfigApplicationContext.getBeanDefinitionNames();
        Arrays.asList(names).stream().forEach(x->System.out.println(x));

        System.out.println(annotationConfigApplicationContext.getBean(Person.class));
        System.out.println(annotationConfigApplicationContext.getBean(Hair.class));
        System.out.println(annotationConfigApplicationContext.getBean(Car.class));
    }

    @Test
    public void test2(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);

        System.out.println("IOC容器创建完成..");

        String [] names = annotationConfigApplicationContext.getBeanDefinitionNames();
        Arrays.asList(names).stream().forEach(x->System.out.println(x));

        Object bean1 = annotationConfigApplicationContext.getBean(Person.class);
        Object bean2 = annotationConfigApplicationContext.getBean(Person.class);

        System.out.println(bean1 == bean2);
    }

    @Test
    public void test03(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);

        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        // 动态获取环境变量的值
        String property = environment.getProperty("os.name");
        System.out.println(property);

        String [] namesForType = applicationContext.getBeanNamesForType(Person.class);
        Arrays.asList(namesForType).stream().forEach(x->System.out.println(x));

        Map<String, Person> persons = applicationContext.getBeansOfType(Person.class);
        System.out.println(persons);
    }

    @Test
    public void test04(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        String[] names = applicationContext.getBeanDefinitionNames();
        Arrays.asList(names).stream().forEach(x->System.out.println(x));

    }

    @Test
    public void test05(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        printBeans(applicationContext);

    }

    @Test
    public void testFactoryBean(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        printBeans(applicationContext);

        Object bean1 = applicationContext.getBean(ColorFactoryBean.class);
        // 工厂bean获取的是
        Object bean2 = applicationContext.getBean("colorFactoryBean");
        Object bean3 = applicationContext.getBean(ColorFactoryBean.class);
        Object bean4 = applicationContext.getBean("colorFactoryBean");
        Object bean5 = applicationContext.getBean("&colorFactoryBean");
        System.out.println("bean1:"+bean1);
        System.out.println("bean2:"+bean2);
        System.out.println("bean3:"+bean3);
        System.out.println("bean4:"+bean4);
        System.out.println("bean5:"+bean5);

        System.out.println("bean1 ==1111 bean2:"+bean1 == bean2);
        System.out.println("bean1 == bean5:"+bean1 == bean5);
        System.out.println("bean2 == bean4:"+bean2 == bean4);

    }

    private void printBeans(AnnotationConfigApplicationContext applicationContext){
        String[] names = applicationContext.getBeanDefinitionNames();
        Arrays.asList(names).stream().forEach(x->System.out.println(x));
    }

}
