package Thread04;

public class CustomerTh extends Thread{
    private Storehouse storehouse;

    public CustomerTh(Storehouse storehouse) {
        this.storehouse = storehouse;
    }

    @Override
    public void run() {
        while (true){
            storehouse.customer();
        }
    }
}

