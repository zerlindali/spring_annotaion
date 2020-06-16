package com.atguigu.controller;

import com.atguigu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author ZerlindaLi create at 2020/5/27 14:29
 * @version 1.0.0
 * @description BookController
 */
@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    public void printDao(){
        bookService.printDao();
    }
}
