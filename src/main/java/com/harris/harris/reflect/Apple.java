package com.harris.harris.reflect;

import lombok.Data;

/**
 * @ClassName Apple
 * @description:
 * @author: wenjunting@zhuanzhuan.com
 * @create: 2021-12-23 17:01
 **/
@Data
public class Apple {

    private Integer price;

    private void privateFuc() {
        System.out.println("我是Apple的私有方法");
    }


    public void publicFuc() {
        System.out.println("我是Apple的公有方法");
    }

    protected void protectedFuc() {
        System.out.println("我是Apple的受保护的方法");
    }
}
