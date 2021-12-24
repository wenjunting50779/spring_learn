package com.harris.harris.cyclic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName B
 * @description:
 * @author: wenjunting@zhuanzhuan.com
 * @create: 2021-12-20 20:11
 **/
@Service
public class BCyclic {
    @Autowired
    private ACyclic a;

    public void say(){
        System.out.println("this is BCyclic");
    }
}
