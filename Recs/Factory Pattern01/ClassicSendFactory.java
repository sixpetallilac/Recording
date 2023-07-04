package NormalFactory;

public class ClassicSendFactory {
    public Send produce(String type){
        if ("mail".equals(type)){
            return new MailSend();
        }
        if ("sms".equals(type)){
            return new SmsSend();
        }
        return null;
    }


    //same function
    public static Send smsproduce(){
        return new SmsSend();
    }
    public static Send mailproduce(){
        return new MailSend();
    }

}
