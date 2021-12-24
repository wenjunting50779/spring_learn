package com.harris.harris.cyclic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName A
 * @description: A对象依赖B  B依赖A
 * @author: wenjunting@zhuanzhuan.com
 * @create: 2021-12-20 20:11
 **/
@Service
public class ACyclic {
    @Autowired
    private BCyclic b;

    public void doCallBCyclic() {
        b.say();
    }
}
