package com.atguigu.config;

import com.atguigu.bean.Car;
import com.atguigu.bean.Hair;
import com.atguigu.bean.Person;
import com.atguigu.service.BookService;
import org.springframework.context.annotation.*;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.stereotype.Controller;

/**
 * @author ZerlindaLi create at 2020/5/27 11:13
 * @version 1.0.0
 * @description MainConfig
 */
// 配置类==配置文件
@Configuration // 告诉Spring这是一个配置类
/*@ComponentScan(value = "com.atguigu",
                includeFilters = {
                                    @ComponentScan.Filter(type = FilterType.ANNOTATION, value = {Controller.class})},
                useDefaultFilters = false
)*/
// @ComponentScan value:指定要扫描的包
// excludeFilters = Filter[] : 指定扫描的时候按照什么规则排除哪些组件
// includeFilters = Filter[] : 指定扫描的时候只需要包含哪些组件
// FilterType.ANNOTATION 按照注解
// FilterType.ASSIGNABLE_TYPE 按照给定的类型
// FilterType.ASPECTJ 使用ASPECTJ表达式
// FilterType.REGEX 使用正则表达式
// FilterType.CUSTOM 使用自定义规则
@ComponentScans(value = {
        @ComponentScan(value = "com.atguigu",
                includeFilters = {
                       /* @ComponentScan.Filter(type = FilterType.ANNOTATION, value = {Controller.class}),
                        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {BookService.class}),*/
                        @ComponentScan.Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})},
                excludeFilters = {
                        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {Person.class})
                },
                useDefaultFilters = false
        )
})
public class MainConfig {

    // 给容器中注册一个Bean; 类型为返回值的类型，id默认是方法名作为id
    @Bean
    public Person person(){
        return new Person("Lisa",20);
    }
/*
    @Bean(value = "hair")
    public Hair hair(){
        return new Hair("red");
    }


    @Bean
    public Car car(){

        return new Car("green", 23);
    }*/
}
