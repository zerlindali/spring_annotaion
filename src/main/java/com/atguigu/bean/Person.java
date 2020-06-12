package com.atguigu.bean;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author ZerlindaLi create at 2020/5/26 17:48
 * @version 1.0.0
 * @description Person
 */
@Data
public class Person {

    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    // 使用@Value赋值
    // 1. 基本数值
    // 2. 可以写SpEL: #{}
    // 3. 可以写${}: 取出配置文件【properties】中的值（在运行环境变量里面的值）
    @Value("Zerlinda")
    private String name;

    @Value("#{28-10}")
    private Integer age;

    @Value("${person.nickName}")
    private String nickName;


}
