package ZZZpractices;

public class SingletonThr {
    private static SingletonThr st =null;
    public SingletonThr getSt(){

        if (null == st){
            synchronized (SingletonThr.class){
                if (null == st){
                    st = new SingletonThr();
                }
            }
        }
        return st;
    }
}
