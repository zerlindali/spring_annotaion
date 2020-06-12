package com.atguigu.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author ZerlindaLi create at 2020/6/1 17:34
 * @version 1.0.0
 * @description MyImportSelector
 * 自定义逻辑，返回需要导入的组件
 */
public class MyImportSelector implements ImportSelector {

    /**
     * 返回值就是要导入到组件中的类的全类名
     * @param annotationMetadata 当前标注@Import注解的类的所有注解信息
     * @return
     */
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        System.out.println("进入selectImports.........");
        // 方法不要返回null
        return new String[]{"com.atguigu.bean.Hair","com.atguigu.bean.Green","com.atguigu.bean.Red"};
    }
}
