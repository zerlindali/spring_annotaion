package com.atguigu.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.env.EnvironmentCapable;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author ZerlindaLi create at 2020/6/1 15:18
 * @version 1.0.0
 * @description LinuxCondition
 * 是否Linux系统
 */
public class LinuxCondition implements Condition {
    /**
     * @param conditionContext 判断条件，使用的向下文（环境）
     * @param annotatedTypeMetadata 注释信息
     * @return
     */
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        // 是否Linux系统
        // 1. 能获取到ioc使用的beanfactory
        ConfigurableListableBeanFactory beanFactory = conditionContext.getBeanFactory();
        // 2. 获取类加载器
        ClassLoader classLoader = conditionContext.getClassLoader();
        // 3. 获取当前环境信息
        Environment environment = conditionContext.getEnvironment();
        // 4. 获取到bean定义的注册类
        BeanDefinitionRegistry registry = conditionContext.getRegistry();

        // 可以判断容器中bean注册情况，也可以给容器中注册bean
        boolean definition = registry.containsBeanDefinition("person");

        String property = environment.getProperty("os.name");
        if(property.contains("Linux")){
            return true;
        }
        return false;
    }
}
