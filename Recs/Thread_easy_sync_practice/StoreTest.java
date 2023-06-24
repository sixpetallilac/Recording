package Thread04;

public class StoreTest {
    public static void main(String[] args) {
        Storehouse s = new Storehouse();

        ProduceTh produceTh = new ProduceTh(s);
        produceTh.setName("生产者：");
        produceTh.start();

        CustomerTh customerTh = new CustomerTh(s);
        customerTh.setName("消费者：");
        customerTh.start();

    }
}
