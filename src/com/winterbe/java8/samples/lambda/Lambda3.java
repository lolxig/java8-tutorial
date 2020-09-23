package com.winterbe.java8.samples.lambda;

import java.util.Comparator;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Common standard functions from the Java API.
 *
 * @author Benjamin Winterberg
 */
public class Lambda3 {

    @FunctionalInterface
    interface Fun {
        void foo();
    }

    public static void main(String[] args) throws Exception {

        Predicate<String> isNumber = s -> s.matches("^\\d+$") || s.matches("\\d\\.\\d");
        Predicate<String> isNumber1 = s -> s.matches("^\\d+$") || s.matches("\\d\\.\\d");

        //定义规则，然后使用test一类的函数来验证传入的参数是否符合该规则
        Predicate<String> predicate = (s) -> s.length() > 0;

        //它具有属性与或非门，可以进行嵌套操作
        predicate.test("foo");              // true
        predicate.negate().test("foo");     // false

        Predicate<Boolean> nonNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;

        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();


        // Functions
        Function<String, Integer> toInteger = Integer::parseInt;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);

        backToString.apply("123");     // "123"


        // Suppliers

        Supplier<Person> personSupplier = Person::new;
        personSupplier.get();   // new Person


        // Consumers

        Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.firstName);
        greeter.accept(new Person("Luke", "Skywalker"));



        // Comparators

        Comparator<Person> comparator = Comparator.comparing(p -> p.firstName);

        Person p1 = new Person("John", "Doe");
        Person p2 = new Person("Alice", "Wonderland");

        comparator.compare(p1, p2);             // > 0
        comparator.reversed().compare(p1, p2);  // < 0


        // Runnables

        Runnable runnable = () -> System.out.println(UUID.randomUUID());
        runnable.run();


        // Callables

        Callable<UUID> callable = UUID::randomUUID;
        callable.call();
    }

}
