package Thread02;

import java.util.ArrayList;
import java.util.List;

public class Threadsync implements Runnable{
    private Account a;
    List<Account> l1 = new ArrayList<>();
//    private Useless useless = new Useless();
    public Threadsync(Account a) {
        this.a = a;
    }


    public void show(Account account){
        synchronized (a) {
            System.out.println(Thread.currentThread().getName());
            l1.add(account);
            Account ac = l1.get(0);
            System.out.println(ac);
//            try {
//                System.out.println("取钱...........");
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            ac.setMoney(ac.getMoney()-200);
            System.out.println(ac);
        }
    }
    public void run(){
       show(a);
    }
    public static void main(String[] args) {
        Account acc = new Account("zhang",1000);
//        Thread th = new Threadsync(acc);//extends thread
//        Thread th2 = new Threadsync(acc);//extends thread

        Threadsync threadsync = new Threadsync(acc);//runnable
        Thread th = new Thread(threadsync);//runnable
        Thread th2 = new Thread(threadsync);//runnable

        th.start();
        System.out.println("th:"+th.getName());
//        System.out.println();
        th2.start();
        try {
            th.join();
            th2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
//class Useless{}