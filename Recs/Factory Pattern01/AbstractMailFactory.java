package NormalFactory;

public class AbstractMailFactory implements FactoryProvider{
    @Override
    public Send produce() {
        return new MailSend();
    }
}
