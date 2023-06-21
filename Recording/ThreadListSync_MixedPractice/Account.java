package Thread02;

public class Account {
    private String name;
    private int money;

    public Account() {
    }

    public Account(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        if (money >= 0){
            this.money = money;
        }else {
            System.out.println("money must>0");
        }
    }

    @Override
    public String toString() {
        return "[username：" + name + "balance：" + money+']';
    }
}
