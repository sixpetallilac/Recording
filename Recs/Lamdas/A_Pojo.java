package Vpackage;

public class A_Pojo {
    String name;
    int age;

    public A_Pojo(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public A_Pojo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void show(){
        System.out.println("pojo show");
    }
    @Override
    public String toString() {
        return "A_Pojo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
