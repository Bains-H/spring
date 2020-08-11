package com.itheima.service;

import com.itheima.exception.MyException;

import java.io.FileNotFoundException;

/**
 * @author huang.b.h.
 * @date 2020/8/11 15:15
 * @DESC:
 */

public interface DemoService {
    void show1();

    void show2();

    void show3() throws FileNotFoundException;

    void show4();

    void show5() throws MyException;
}
