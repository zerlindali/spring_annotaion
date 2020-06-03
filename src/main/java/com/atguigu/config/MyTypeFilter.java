package com.atguigu.config;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * @author ZerlindaLi create at 2020/5/28 13:48
 * @version 1.0.0
 * @description MyTypeFilter
 */
public class MyTypeFilter implements TypeFilter {

    /**
     * metadataReader: 读取当前正在扫描的类的信息
     * metadataReaderFactory: 可以获取到其他任何类的信息
     *
     * @param metadataReader the metadata reader for the target class
     * @param metadataReaderFactory a factory for obtaining metadata readers
     * @return
     * @throws IOException
     */
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        // 获取当前类注解的信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        // 获取当前正在扫描的类的类信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        // 获取当前类资源(类资源)
        Resource resource = metadataReader.getResource();

        String className = classMetadata.getClassName();
        System.out.println("--------->" + className);
/*
        if(className.contains("er")){
            return true;
//        }*/
        return false;
    }
}
