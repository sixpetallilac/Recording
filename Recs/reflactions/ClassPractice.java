package ReflectionPractices;

public class ClassPractice {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<String> stringClass = String.class;
        System.out.println(stringClass);
        String str = "hi";
        Class<? extends String> aClass = str.getClass();
        System.out.println(aClass);
        Class<Integer> type = Integer.TYPE;
        System.out.println(type);
        Class c = Class.forName("java.lang.String");
        System.out.println(c);

    }
}
