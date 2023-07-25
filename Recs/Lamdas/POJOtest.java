package Vpackage;

import ArraysPractice.Person;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class POJOtest {
    public static void main(String[] args) {
        A_Pojo aPojo = new A_Pojo("zhangsan",100);
        Runnable runnable = ()->aPojo.show();
        runnable.run();

        Supplier supplier = aPojo::getName;
        System.out.println(supplier.get());


        Function<String,Integer> functions = (s) -> Integer.valueOf(s);
        Function<String,Integer> functions2 = Integer::valueOf;
        System.out.println(functions.apply(String.valueOf(aPojo.getAge())));

        System.out.println("2"+functions2.apply(String.valueOf(aPojo.getAge())));

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2,o1);
            }
        };

        Comparator<Integer> comparator2 = Integer::compare;

        System.out.println(comparator.compare(100,200));
        System.out.println(comparator2.compare(100,200));

        Comparator<Integer> comparator3 = Integer::compareTo;
        System.out.println();

        BiFunction<String, Integer, A_Pojo> biFunction = new BiFunction<String, Integer, A_Pojo>() {
            @Override
            public A_Pojo apply(String s, Integer integer) {
                return new A_Pojo(s,integer);
            }
        };
        BiFunction<String, Integer, A_Pojo> biFunction2 = A_Pojo::new;
        System.out.println(biFunction2.apply("name1",200));

        Function<Integer,A_Pojo[]> farr = A_Pojo[]::new;
        System.out.println(Arrays.toString(farr.apply(5)));

    }
}
