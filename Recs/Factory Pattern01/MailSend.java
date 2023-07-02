package NormalFactory;

public class MailSend implements Send{
    @Override
    public void sender() {
        System.out.println("mail sender");
    }
}
