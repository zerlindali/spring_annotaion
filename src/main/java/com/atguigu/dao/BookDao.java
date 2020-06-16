package com.atguigu.dao;

import lombok.Data;
import org.springframework.stereotype.Repository;

/**
 * @author ZerlindaLi create at 2020/5/27 14:29
 * @version 1.0.0
 * @description BookDao
 */
// 名字默认是类名首字母小写
@Repository
@Data
public class BookDao {

    private String lable = "1";

    @Override
    public String toString() {
        return "BookDao{" +
                "lable='" + lable + '\'' +
                '}';
    }
}
