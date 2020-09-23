package com.winterbe.java8.samples.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * @author Benjamin Winterberg
 */
public class Streams1 {

    public static void main(String[] args) {

        List<String> list = new ArrayList<String>() {{
            add("ddd2");
            add("aaa2");
            add("bbb1");
            add("aaa1");
            add("bbb3");
            add("ccc");
            add("bbb2");
            add("ddd1");
        }};


        //过滤器，挑选出以a开头的字符串
        list.stream()   //转为流
                .filter((s) -> s.startsWith("a"))   //过滤器
                .forEach(System.out::println);      //全部打印

        // "aaa2", "aaa1"

        // sorting
        list
                .stream()   //转流
                .sorted()   //排序，可以传入一个比较器
                .filter((s) -> s.startsWith("a"))   //过滤输出
                .forEach(System.out::println);

        // "aaa1", "aaa2"

        // mapping
        list
                .stream()
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

        // "DDD2", "DDD1", "CCC", "BBB3", "BBB2", "AAA2", "AAA1"


        // matching

        boolean anyStartsWithA = list
                .stream()
                .anyMatch((s) -> s.startsWith("a"));

        System.out.println(anyStartsWithA);      // true

        boolean allStartsWithA = list
                .stream()
                .allMatch((s) -> s.startsWith("a"));

        System.out.println(allStartsWithA);      // false

        boolean noneStartsWithZ = list
                .stream()
                .noneMatch((s) -> s.startsWith("z"));

        System.out.println(noneStartsWithZ);      // true


        // counting

        long startsWithB = list
                .stream()
                .filter((s) -> s.startsWith("b"))
                .count();

        System.out.println(startsWithB);    // 3


        // reducing

        Optional<String> reduced = list
                        .stream()
                        .sorted()
                        .reduce((s1, s2) -> s1 + "#" + s2);

        reduced.ifPresent(System.out::println);
        // "aaa1#aaa2#bbb1#bbb2#bbb3#ccc#ddd1#ddd2"


    }

}
