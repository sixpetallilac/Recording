package Thread04;

public class ProduceTh extends Thread{
    private Storehouse storehouse;

    public ProduceTh(Storehouse storehouse) {

        this.storehouse = storehouse;
    }

    @Override
    public void run() {
        while (true){
            storehouse.produce();
        }
    }
}
