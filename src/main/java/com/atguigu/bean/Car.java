package com.atguigu.bean;

import lombok.Data;

/**
 * @author ZerlindaLi create at 2020/5/28 15:25
 * @version 1.0.0
 * @description Car
 */
@Data
public class Car {
    public Car() {
    }

    public Car(String color, Integer price) {
        this.color = color;
        this.price = price;
    }

    private String color;
    private Integer price;
}
