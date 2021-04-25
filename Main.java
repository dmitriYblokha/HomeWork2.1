package com.gmail.dimablogha;

import java.lang.reflect.*;

class Sample {
    @Test(a = 5, b = 2)
    public void test (int a, int b) {
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}

public class Main {

    public static void main(String[] args) {
        final Class<?> cls = Sample.class;
        Sample smp = new Sample();
        Method[] methods = cls.getMethods();

        for (Method method: methods) {
            if(method.isAnnotationPresent(Test.class)){
                try {
                    Test ls = method.getAnnotation(Test.class);
                    method.invoke(smp,ls.a(),ls.b());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
