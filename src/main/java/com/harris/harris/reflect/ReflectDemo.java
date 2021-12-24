package com.harris.harris.reflect;

import org.springframework.util.Assert;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @ClassName ReflectDemo
 * @description:
 * @author: wenjunting@zhuanzhuan.com
 * @create: 2021-12-23 17:03
 **/
public class ReflectDemo {

    public static void main(String[] args) throws Exception {
        doNormalCall();

        // 1.1 根据全限定类名获取到Class对象
        Class<?> aClass = Class.forName("com.harris.harris.reflect.Apple");

        // 1.2 通过类.class 获取class对象
        Class<?> bClass = Apple.class;

        // 1.3 通过对象实例.getClass()获取对象
        Apple apple = new Apple();
        Class<?> cClass = apple.getClass();

        Assert.isTrue(aClass.equals(bClass));

        // 2.1 获取到class的所有方法
        Object apply1 = aClass.newInstance();
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            // 2.2 普通方法调用
            if("setPrice".equals(declaredMethod.getName())){
                // 将价格设置为3
                declaredMethod.invoke(apply1,3);
                System.out.println(apply1);
            }
            // 2.3 私有方法调用
            if("privateFuc".equals(declaredMethod.getName())){
                // 取消访问限制就可以调用私有方法
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(apply1);
            }
        }




        Field[] declaredFields = aClass.getDeclaredFields();
        AnnotatedType[] annotatedInterfaces = aClass.getAnnotatedInterfaces();

        System.out.println(declaredFields);



    }


    private static void doNormalCall(){
        // 正常调用 不能调用私用方法
        Apple apple = new Apple();
        apple.protectedFuc();
        apple.publicFuc();
    }

}
