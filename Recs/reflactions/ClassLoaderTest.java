package ReflectionPractices;

public class ClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        Class<?> aClass = classLoader.loadClass("java.lang.String");
        System.out.println(aClass);

        ClassLoader classLoader1 = ClassLoaderTest.class.getClassLoader();
        Class<?> aClass1 = classLoader1.loadClass("java.lang.Integer");
        System.out.println(aClass1);
    }
}
