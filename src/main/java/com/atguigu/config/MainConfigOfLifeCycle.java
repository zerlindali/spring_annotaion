package com.atguigu.config;

import com.atguigu.bean.Car;
import com.atguigu.bean.Cat;
import com.atguigu.bean.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * bean的生命周期
 *  bean的创建-->初始化-->销毁的过程
 * 容器管理bean的生命周期：
 * 我们可以自定义初始化和销毁方法，容器在bean进行到当前的生命周期的时候，来调用我们自定义的初始化和销毁方法
 *
 * 构造（对象创建）
 *      单实例：在容器启动的时候创建对象
 *      多实例：在每次获取的时候创建对象
 * 初始化：
 *      对象创建完成，并赋值好，调用初始化方法
 * 销毁：
 *      单实例：容器销毁时调用
 *      多实例：容器不会管理这个bean，容器不会调用销毁方法，什么时候销毁由你自己决定
 *
 * BeanPostProcessor原理
 * populateBean(beanName, mbd, instanceWrapper); // 为bean属性赋值
 * initializeBean
 * {
 *     遍历得到容器中所有的BeanPostProcessor; 然后挨个执行。一旦返回null, 跳出for循环，不会执行后边的BeanPostProcessor.postProcessBeforeInitialization
 *   wrappedBean = applyBeanPostProcessorsBeforeInitialization(wrappedBean, beanName);
 *   invokeInitMethods(beanName, wrappedBean, mbd); // 执行自定义初始化方法
 *   applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);
 * }
 *
 *
 * 1). 指定初始化销毁方法
 *       通过@Bean指定init-method和destroy-method
 * 2). 通过让Bean实现InitializingBean（定义初始化逻辑），
 *       DisposableBean(定义销毁逻辑)
 * 3). 可以使用JSR250：
 *       @PostConstuct : 在bean创建完成并且属性赋值完成，来执行初始化方法
 *       @PreDestroy : 在容器销毁bean之前，通知我们进行清理工作
 * 4). BeanPostProcessor【interface】: bean的后置处理器
 *       在bean初始化的前后进行处理工作:
 *       postProcessBeforeInitialization: 在初始化之前工作
 *       postProcessAfterInitialization： 在初始化之后工作
 *
 * Spring底层对BeanPostProcessor的使用 :
 *     bean的赋值，注入其他组件，@Autowired,生命周期注解功能，@Ayncs, xxx BeanPostProcessor;
 */
@Configuration
@ComponentScan("com.atguigu.bean")
public class MainConfigOfLifeCycle {

    @Scope("prototype")
    @Bean(initMethod = "init", destroyMethod = "destory")
    public Car car(){
        return new Car();
    }

    @Bean
    public Cat cat(){
        return new Cat();
    }

    @Bean
    public Dog dog(){
        return new Dog();
    }
}
