package ProxyPractice;

public class ShowImpl implements Show{

    @Override
    public String showfunction(String str) {
        return str+"impl";
    }
}
