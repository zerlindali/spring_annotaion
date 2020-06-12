package com.atguigu.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * 创建一个Spring定义的工厂bean
 */
public class ColorFactoryBean implements FactoryBean<Color> {

    /**
     * 返回一个Color对象，这个对象会添加到容器中
     * @return
     * @throws Exception
     */
    @Override
    public Color getObject() throws Exception {
        System.out.println("ColorFactoryBean......getObject....");
        return new Color();
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

    /**
     * 是否是单例?
     * true: 这个bean单实例，在容器中会保存一份
     * false: 多实例，每次获取都会创建一个新的。
     * @return
     */
    @Override
    public boolean isSingleton() {
        return false;
    }
}
