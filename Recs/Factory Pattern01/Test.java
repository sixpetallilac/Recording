package NormalFactory;

public class Test {
    public static void main(String[] args) {
        System.out.println("****************");
        SendFactory.smsproduce().sender();
        SendFactory.mailproduce().sender();
    }
}
