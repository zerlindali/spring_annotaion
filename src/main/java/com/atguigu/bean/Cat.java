package com.atguigu.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Cat implements InitializingBean, DisposableBean {
    public Cat() {
        System.out.println("cat constructor...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("cat....... destory........");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("cat...... afterPropertiesSet........");
    }
}
