package com.atguigu.service;

import com.atguigu.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.inject.Inject;

/**
 * @author ZerlindaLi create at 2020/5/27 14:29
 * @version 1.0.0
 * @description BookService
 */
@Service
public class BookService {

//    @Qualifier("bookDao3")
    @Autowired(required = false)
//    @Resource(name = "bookDao3")
//    @Inject
    private BookDao bookDao;

    public void printDao(){
        System.out.println(bookDao);
    }

}
