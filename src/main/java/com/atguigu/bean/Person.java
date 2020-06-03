package com.atguigu.bean;


import lombok.Data;

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

    private String name;

    private Integer age;


}
