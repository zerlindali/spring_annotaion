package com.atguigu.config;

import com.atguigu.aop.LogAspects;
import com.atguigu.aop.MathCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author ZerlindaLi create at 2020/6/15 17:36
 * @version 1.0.0
 * @description MainConfigOfAOP
 * AOP: 【动态代理】
 *      指程序运行期间动态的将某段代码切入到指定方法指定位置进行运行的编程方式
 *
 * 1. 导入aop模块:Spring AOP:(spring-aspects)
 * 2. 定义一个业务逻辑类（MathCalculator）: 在业务逻辑运行的时候将日志进行打印（方法之前，方法运行结束，方法异常）
 * 3. 定义一个日志切面类（LogAspects): 切面类里面的方法需要动态感知MathCalculator.div运行到哪里，然后执行
 *      通知方法：
 *          前置通知(@Before)：logStart：在目标方法(div)运行之前运行
 *          后置通知(@After)：logEnd: 在目标方法(div)运行结束之后运行(无论方法是正常结束还是异常结束)
 *          返回通知(@AfterReturning)：logReturn：在目标方法(div)正常返回之后运行
 *          异常通知(@AfterThrowing)：logException：在目标方法(div)出现异常以后运行
 *          环绕通知(@Around)：动态代理：手动推进目标方法运行(joinPoint.procced())
 * 4. 给切面类的目标方法标注何时何地运行
 * 5. 将切入类和业务逻辑类（目标方法所在类）都加入到容器中
 * 6. 必须告诉Spring,哪个类是切换类（给切面类上加一个注解）
 * [7]. 给配置类中加@EnableAspectJAutoProxy【开启基于注解的aop模式】
 * 8. 在Spring中有很多@EnableXXX功能
 */
@Configuration
@EnableAspectJAutoProxy
public class MainConfigOfAOP {

    // 业务逻辑类加入容器中
    @Bean
    public MathCalculator calculator(){
        return new MathCalculator();
    }

    // 切面类加入到容器中
    @Bean
    public LogAspects logAspects(){
        return new LogAspects();
    }
}
