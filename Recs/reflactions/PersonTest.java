package ReflectionPractices;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public class PersonTest {
    public static void main(String[] args) {
        RandomAccessFile ra = null;
        try {//read from file
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

            Class c1 = Class.forName(String.valueOf(sb));
            Object o = c1.newInstance();
            System.out.println(o);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (FileNotFoundException notFoundException) {
            notFoundException.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
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
