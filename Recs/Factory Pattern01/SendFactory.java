package NormalFactory;

public class SendFactory {
    public Send produce(String type){
        if ("mail".equals(type)){
            return new MailSend();
        }
        if ("sms".equals(type)){
            return new SmsSend();
        }
        return null;
    }
    public static Send smsproduce(){
        return new SmsSend();
    }
    public static Send mailproduce(){
        return new MailSend();
    }

}
