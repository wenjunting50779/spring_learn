package com.harris.harris;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;
import org.apache.commons.jexl3.JexlBuilder;
import org.apache.commons.jexl3.JexlContext;
import org.apache.commons.jexl3.JexlExpression;
import org.apache.commons.jexl3.MapContext;
import org.codehaus.janino.ExpressionEvaluator;
import org.junit.jupiter.api.Test;
import org.mvel2.MVEL;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @ClassName ExpressionTest
 * @description: 表达式引擎对比
 * @author: wenjunting@zhuanzhuan.com
 * @create: 2021-11-26 09:25
 **/
public class ExpressionTest {
    @Test
    public void t1() throws Exception {
        String expression = "10<=b&&b<12||10<=a && b<12";
        Random random = new Random();
        int max = 100000;

        long s1 = System.currentTimeMillis();
        Serializable serializable = MVEL.compileExpression(expression);
        for (int i = 0; i < max; i++) {
            Map<String, Object> env = new HashMap<>();
            env.put("b", random.nextInt(11));
            env.put("c", random.nextInt(11));
            MVEL.executeExpression(serializable, env);
        }
        System.out.println("mvel 表达式预编译的情况 执行" + (max / 10000) + "w次耗时:" + (System.currentTimeMillis() - s1));


        long s = System.currentTimeMillis();
        Expression compiledExp = AviatorEvaluator.compile(expression);
        // 执行表达式
        for (int i = 0; i < max; i++) {
            Map<String, Object> env = new HashMap<>();
            env.put("b", random.nextInt(11));
            env.put("c", random.nextInt(11));
            compiledExp.execute(env);
        }
        System.out.println("Aviator 表达式预编译的情况 执行" + (max / 10000) + "w次耗时:" + (System.currentTimeMillis() - s));


        long s2 = System.currentTimeMillis();
        ExpressionEvaluator ee = new ExpressionEvaluator();
        ee.setParameters(new String[]{"c", "b"}, new Class[]{int.class, int.class});
        // 设置表达式的返回结果也为int类型
        ee.setExpressionType(boolean.class);
        // 这里处理（扫描，解析，编译和加载）上面定义的算数表达式.
        ee.cook(expression);
        for (int i = 0; i < max; i++) {
            ee.evaluate(new Object[]{random.nextInt(11), random.nextInt(11)});
        }
        System.out.println("janino 表达式预编译的情况 执行" + (max / 10000) + "w次耗时:" + (System.currentTimeMillis() - s2));

        long s3 = System.currentTimeMillis();
        JexlBuilder builder = new JexlBuilder();
        JexlExpression expression1 = builder.create().createExpression(expression);
        JexlContext jexlContext = new MapContext();
        jexlContext.set("b", random.nextInt(11));
        jexlContext.set("c", random.nextInt(11));
        for (int i = 0; i < max; i++) {
            expression1.evaluate(jexlContext);
        }
        System.out.println("Jexl 表达式预编译的情况 执行" + (max / 10000) + "w次耗时:" + (System.currentTimeMillis() - s3));

    }

}
