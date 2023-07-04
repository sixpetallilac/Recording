package NormalFactory;

public class AbstractSMSFactory implements FactoryProvider{
    @Override
    public Send produce() {
        return new SmsSend();
    }
}
