package com.atguigu.bean;

import lombok.Data;

/**
 * @author ZerlindaLi create at 2020/5/27 11:34
 * @version 1.0.0
 * @description Hair
 */
@Data
public class Hair {

    public Hair() {
    }

    public Hair(String color) {
        this.color = color;
    }

    private String color;
}
