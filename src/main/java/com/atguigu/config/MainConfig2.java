package com.atguigu.config;

import com.atguigu.bean.Car;
import com.atguigu.bean.Color;
import com.atguigu.bean.Hair;
import com.atguigu.bean.Person;
import com.atguigu.condition.LinuxCondition;
import com.atguigu.condition.WindowsCondition;
import org.springframework.context.annotation.*;

/**
 * @author ZerlindaLi create at 2020/6/1 13:33
 * @version 1.0.0
 * @description MainConfig2
 */
// 类中组件统一设置，满足当前条件，这个类中配置的所有bean才能生效
@Conditional({WindowsCondition.class})
@Configuration
@Import({Color.class, Car.class, Hair.class})
// 导入组件，id默认是组件的全类名
public class MainConfig2 {

    // 默认是单实例的

    /**
     * 	 * @see ConfigurableBeanFactory#SCOPE_PROTOTYPE
     * 	 * @see ConfigurableBeanFactory#SCOPE_SINGLETON
     * 	 * @see org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST
     * 	 * @see org.springframework.web.context.WebApplicationContext#SCOPE_SESSION
     *
     * prototype 多实例: IOC容器启动时，并不会创建方法放入容器中。而是我们每次获取时才会调用方法获取实例。
     * singleton 单实例（默认值）：ioc容器启动时，会调用方法创建对象，放入ioc容器中，以后每次获取就是直接从容器(map.get())中拿
     * request 同一个请求创建一个实例
     * session 同一个会话创建一个实例
     *
     * 懒加载：
     *          单实例bean: 默认在容器启动的时候创建对象；
     *          懒加载：容器启动不创建对象。第一次使用(获取)Bean创建对象，
     *
     */
//    @Scope(value = "prototype")

    @Lazy
    @Bean
    public Person person(){
        System.out.println("给容器中添加Person...");
        return new Person("张三",24);
    }

    /**
     * @Conditional{Condition} : 按照一定的条件进行判断，满足条件的容器中注册bean
     *
     * 如果系统是windows, 放("bill")，
     * 如果是linux系统，给容器中注册("linus")
     */
    @Conditional({WindowsCondition.class})
    @Bean("bill")
    public Person person01(){
        System.out.println("给容器中添加Bill...");
        return new Person("Bill Gates", 62);
    }

    @Conditional({LinuxCondition.class})
    @Bean("linus")
    public Person person02(){
        System.out.println("给容器中添加linus...");
        return new Person("linus", 48);
    }

    /**
     * 给容器中注册组件“
     * 1). 包扫描+组件标注注解（@Controller/@Service/@Repository/@Component）[自己写的类]
     * 2). @Bean [导入的第三方包里面的组件]
     * 3). @Import[快速给容器中导入一个组件]
     *      1). @Import(要导入到容器中的组件)：容器中就会自动注册这个组件，id默认是全类名
     *      2). ImportSelector: 返回需要导入的组件的全类名数组：
     */
}
