package Vpackage;

import java.util.function.Consumer;

public class A001Test {
    public static void main(String[] args) {
        Consumer consumer = new Consumer() {
            @Override
            public void accept(Object o) {
                System.out.println("test");
            }
        };
        Consumer consumer1 = (o)-> System.out.println("lamda"+o);

        consumer1.accept("test");

    }
}
