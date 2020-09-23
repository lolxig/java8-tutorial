package com.xig.defaultMethods;

/**
 * created with IntelliJ IDEA 2019.3
 * author: xig
 * date: 2020/9/23 8:45
 * version: 1.0
 * description: to do
 */
public interface Formula {

    double calculate(int a);

    default double sqrt(int a) {
        return Math.sqrt(a);
    }

}
