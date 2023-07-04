package ObservablePr;

import java.util.Observable;

public class Wechat extends Observable {
    public void sendFunction(String str){
        this.setChanged();
        this.notifyObservers(str);
    }

    public static void main(String[] args) {
        Wechat w = new Wechat();
        User u = new User();
        w.addObserver(u);//Regist observer
        w.sendFunction("hi");//this.setChanged()
    }
}
