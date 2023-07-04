package NormalFactory;

public class Test {
    public static void main(String[] args) {
        ClassicSendFactory.smsproduce().sender();
        ClassicSendFactory.mailproduce().sender();


        System.out.println("****************");
        FactoryProvider fp1 = new AbstractSMSFactory();
        fp1.produce().sender();//abstract factory
        FactoryProvider fp2 = new AbstractMailFactory();
        fp2.produce().sender();
    }
}
