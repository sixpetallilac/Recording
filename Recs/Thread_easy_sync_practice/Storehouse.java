package Thread04;

public class Storehouse {
    private int counts = 0;

    public synchronized void produce() {
        try {
            notify();
            if (counts<10){
                System.out.println(Thread.currentThread().getName()+"  库存数量："+counts);
                counts +=5;
                System.out.println(Thread.currentThread().getName()+"  库存数量："+counts);
                Thread.sleep(100);
            }else {
                System.out.println("produce waiting");
                wait();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void customer() {
        try {
            notify();
            if (counts>=2){
                System.out.println(Thread.currentThread().getName()+"  库存数量："+counts);
                counts -= 2;
                Thread.sleep(500);
            }else {
                System.out.println("cus waiting");
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
