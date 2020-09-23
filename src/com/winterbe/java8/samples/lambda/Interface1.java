package com.winterbe.java8.samples.lambda;

/**
 * @author Benjamin Winterberg
 */
public class Interface1 {

    interface Formula {

        //正常接口方法
        double calculate(int a);

        //接口默认方法
        default double sqrt(int a) {
            return Math.sqrt(positive(a));
        }

        //接口静态方法
        static int positive(int a) {
            return Math.max(a, 0);
        }
    }

    public static void main(String[] args) {
        Formula formula1 = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 100);
            }
        };

        System.out.println("formula1.calculate(100) = " + formula1.calculate(100));
        System.out.println("formula1.sqrt(-23) = " + formula1.sqrt(-23));
        System.out.println("Formula.positive(-4) = " + Formula.positive(-4));

        Formula formula2 = a -> Math.sqrt(a * 100);

    }


}