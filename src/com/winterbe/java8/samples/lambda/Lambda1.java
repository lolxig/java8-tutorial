package com.winterbe.java8.samples.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * @author Benjamin Winterberg
 */
public class Lambda1 {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

        names.sort(Comparator.reverseOrder());
        System.out.println("names = " + names);

        names.sort(Comparator.reverseOrder());
        System.out.println("names = " + names);

        names.sort(Comparator.reverseOrder());
        System.out.println("names = " + names);

        names.sort(Comparator.reverseOrder());
        System.out.println("names = " + names);

        names.sort(Collections.reverseOrder());
        System.out.println("names = " + names);

        List<String> names2 = Arrays.asList("peter", null, "anna", "mike", "xenia");
        names2.sort(Comparator.nullsLast(String::compareTo));
        System.out.println("names2 = " + names2);

        List<String> names3 = null;

        //Optional.ofNullable表示传入的对象可以为空，返回Optional对象或者null。如果返回不为空，则可以执行ifPresent()
        Optional.ofNullable(names3).ifPresent(list -> list.sort(Comparator.naturalOrder()));
        System.out.println(names3);
    }

}