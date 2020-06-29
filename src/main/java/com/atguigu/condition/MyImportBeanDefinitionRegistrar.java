package com.atguigu.condition;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar{

    /**
     * AnnotationMetadata 当前类的注解信息
     * BeanDefinitionRegistry BeanDefinition注册类
     *      把所有需要添加到容器中的bean,调用ImportBeanDefinitionRegistrar.registerBeanDefinitions手工注册进来
     * @param importingClassMetadata
     * @param registry
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean definition1 = registry.containsBeanDefinition("com.atguigu.bean.Green");
        boolean definition2 = registry.containsBeanDefinition("com.atguigu.bean.Red");
        if(definition1 && definition2){
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition("com.atguigu.bean.Color");
            registry.registerBeanDefinition("color", rootBeanDefinition);
        }
    }
}
