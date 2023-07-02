package NormalFactory;

public class SmsSend implements Send{
    @Override
    public void sender() {
        System.out.println("sms send");
    }
}
