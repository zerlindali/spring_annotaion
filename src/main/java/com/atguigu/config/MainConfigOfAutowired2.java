package com.atguigu.config;

import com.atguigu.bean.Car;
import com.atguigu.bean.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author ZerlindaLi create at 2020/6/15 11:29
 * @version 1.0.0
 * @description MainConfigOfAutowired2
 * 3) @Autowired: 构造器，方法，参数，属性：都是从容器中获取参数组件的值
 *      1). 标注在方法位置: @Bean+方法参数，参数从容器中获取。默认不写@Autowired,效果都是一样的，都能自动装配
 *      2). 标注在构造器上：如果组件只有一个有参构造器，这个有参构造器的@Autowired可以省略，参数位置的组件还是可以自动从容器中获取
 *      3). 放在参数位置
 * 4) 自定义组件想要使用Spring容器底层的一些组件（ApplicationContext, BeanFactory, xxx）
 *      自定义组件实现xxxAware;在创建对象的时候，会调用接口 规定的方法注入相关组件 Aware
 *      把Sprig底层一些组件注入到我们自己的bean中；
 *      xxxAware：功能使用xxxProcessor;
 *          ApplicationContextAware ==> ApplicationContextAwareProcessor
 *
 */
@Configuration
@ComponentScan(value = {"com.atguigu.service","com.atguigu.dao", "com.atguigu.controller","com.atguigu.bean"})
public class MainConfigOfAutowired2 {

    /**
     * @Bean 标注的方法创建对象的时候，方法参数的值从容器中获取
     * @param car
     * @return
     */
    @Bean
    public Color color(@Autowired Car car){
        Color color = new Color();
        color.setCar(car);
        return color;
    }
}
