package com.atguigu.bean;

import org.springframework.stereotype.Component;

/**
 * @author ZerlindaLi create at 2020/6/15 11:30
 * @version 1.0.0
 * @description Boss
 */
// 默认加在IOC容器中的组件，容器启动会调用无参构造器创建对象，再进行初始化赋值操作
@Component
public class Boss {

    // 构造器要用的组件也是都从容器中获取
//    @Autowired
    public Boss(Car car) {
        this.car = car;
        System.out.println("Boss.....有参构造器");
    }

    private Car car;

    public Car getCar() {
        return car;
    }

//    @Autowired
    // 标注在方法上，Spring容器创建当前对象的时候，就会调用所标注的方法，完成复制
    // 方法使用的参数，自定义类型的值从IOC容器中获取
    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "car=" + car +
                '}';
    }
}
