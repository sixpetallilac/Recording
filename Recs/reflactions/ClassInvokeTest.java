package ReflectionPractices;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ClassInvokeTest {
    public static void main(String[] args) throws Exception {
        Class<?> aClass = Class.forName("ReflectionPractices.Person");
        Constructor<?> constructor = aClass.getConstructor();
        Object unknownobj = constructor.newInstance();//creat new
        //set
        Method setName = aClass.getDeclaredMethod("setName", String.class);
        setName.invoke(unknownobj,"testnaame");
        //get
        Method getName = aClass.getDeclaredMethod("getName");
        Object invoke = getName.invoke(unknownobj);
        //sout
        System.out.println(invoke);
    }
}
