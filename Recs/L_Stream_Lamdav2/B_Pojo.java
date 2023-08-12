package WPackage;

import Vpackage.A_Pojo;

import java.util.function.Function;

public class B_Pojo extends A_Pojo implements Function {
    public B_Pojo(String name, int age) {
        super(name, age);
    }

    public B_Pojo() {
    }


    @Override
    public Object apply(Object o) {
        return new A_Pojo("hi",200);
    }
}
