package com.winterbe.java8.samples.lambda;

/**
 * @author Benjamin Winterberg
 */
public class Lambda2 {

    @FunctionalInterface
    public interface Converter<F, T> {
        T convert(F from);
    }

    static class Something {
        String startsWith(String s) {
            return String.valueOf(s.charAt(0));
        }
    }

    interface PersonFactory<P extends Person> {
        P create(String firstName, String lastName);
    }

    public static void main(String[] args) {
        Converter<String, Integer> converter = Integer::parseInt;
        System.out.println("converter.convert(\"123\") = " + converter.convert("123"));

        // method reference
        Converter<String, Integer> integerConverter2 = Integer::valueOf;
        Integer converted2 = integerConverter2.convert("123");
        System.out.println(converted2);   // result: 123


        Something something = new Something();
        //传入自定义的方法接口
        Converter<String, String> stringConverter = something::startsWith;
        String converted3 = stringConverter.convert("Java");
        System.out.println(converted3);    // result J

        // 传入构造方法参数
        PersonFactory<Person> personFactory = Person::new;
        Person person = personFactory.create("Peter", "Parker");
    }
}
