package ProxyPractice;

public class ShowProxy implements Show{
    private final Show si;

    public ShowProxy(Show si) {
        this.si = si;
    }

    @Override
    public String showfunction(String str) {
        System.out.println("statichi:");
        String showfunction = si.showfunction(str);
        System.out.println(showfunction);
        System.out.println("staticbye");
        return null;
    }
}
