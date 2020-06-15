package com.atguigu.test;

import com.atguigu.config.MainConfigOfProfile;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * @author ZerlindaLi create at 2020/6/15 16:17
 * @version 1.0.0
 * @description IOCTest_Profile
 */
public class IOCTest_Profile {

    /**
     * 1. 使用命令行动态参数: 在虚拟机参数位置加载 -Dspring.profiles.active=test
     * 2. 使用代码的方式激活某种环境
     */
    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 1. 创建一个applicationContext
        // 2. 创建需要激活的环境
        applicationContext.getEnvironment().setActiveProfiles("test","dev");
        // 3. 注册主配置类
        applicationContext.register(MainConfigOfProfile.class);
        // 4. 启动刷新容器
        applicationContext.refresh();
        printBeans(applicationContext);
    }

    private void printBeans(AnnotationConfigApplicationContext applicationContext){
        String[] names = applicationContext.getBeanDefinitionNames();
        Arrays.asList(names).stream().forEach(x->System.out.println(x));
    }
}
