package ReflectionPractices;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PersonTest2 {
    public static void main(String[] args) {
        RandomAccessFile ra = null;
        try {
            ra = new RandomAccessFile("L:/iotest/class.txt","r");
            byte[] bytes = new byte[8];
            int read = 0;
            StringBuilder sb = new StringBuilder();
            while ((read = ra.read(bytes))!=-1){
                String str = new String(bytes,0,read);
                sb.append(str);
            }
            String s = String.valueOf(sb);
            System.out.println("stringbuilder read:"+s);


            //file read done, class reflaction steps
            Class classcons = Class.forName(String.valueOf(sb));
            //use class constructor to replace class***.newinstance, the second has already out-of-date
            //non-argument
            Constructor constructor = classcons.getConstructor();
            System.out.println("constructor.newInstance():->"+constructor.newInstance());
            //with-argument
            constructor = classcons.getConstructor(String.class,int.class);
            Object obj = constructor.newInstance("zhangsan", 50);
            System.out.println("constructor.newInstance():->"+obj);
            //get all cons (when you don't know parameter)
            Constructor[] constructors = classcons.getConstructors();
            System.out.println();
            System.out.println("***********************construction");
            //some construction get functions
            for (Constructor cons:constructors){
                System.out.println(cons.getModifiers());
                System.out.println(cons.getName());
                for (Class parameterType : cons.getParameterTypes()) {
                    System.out.println(parameterType);//return array address loop
                }
                System.out.println();
            }
            //field test
            Field field = classcons.getDeclaredField("name");
            field.setAccessible(true);//if it's private set it to true
            System.out.println(field.get(obj));
            field.set(obj,"lisi");
            System.out.println("changed:"+field.get(obj));
            //some field get functions
            System.out.println("***********************functions");
            Field[] declaredFields = classcons.getDeclaredFields();
            for (Field f:declaredFields){
                System.out.println(f.getModifiers());
                System.out.println(f.getType());
                System.out.println(f.getName());
                System.out.println("-----");
            }
            //some method get funcions
            Method setname = classcons.getMethod("setName",String.class);
            System.out.println("+++++++++++++++++++++"+setname);
            for (Method declaredMethod : classcons.getDeclaredMethods()) {
                System.out.println(declaredMethod.getModifiers());
                System.out.println(declaredMethod.getReturnType());
                System.out.println(declaredMethod.getName());
                for (Class<?> parameterType : declaredMethod.getParameterTypes()) {
                    System.out.println("parameterType.getTypeName():"+parameterType);
                }
                for (Class<?> exceptionType : declaredMethod.getExceptionTypes()) {
                    System.out.println("getExceptionTypes()"+exceptionType);
                }
                System.out.println("-----");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } finally {
            if (null != ra){
                try {
                    ra.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
