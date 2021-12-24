package com.harris.harris.cyclic;

import com.harris.harris.util.JsonUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @ClassName Test
 * @description: 循环依赖测试
 * @author: wenjunting@zhuanzhuan.com
 * @create: 2021-12-20 20:12
 **/
@SpringBootTest
public class TestCyclic {
    @Autowired
    private ACyclic aCyclic;

    @Test
    public void t1(){
        aCyclic.doCallBCyclic();
    }
}
