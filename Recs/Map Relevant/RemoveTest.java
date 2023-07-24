package MapPractice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RemoveTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList(){{
            add(100);
            add(200);
            add(300);
            add(400);
            add(500);
            add(500);
            add(600);
            add(600);
        }};//a convient way
        int count = 0;
//        int size = list.size();
//        for (int i = 0;i<size;i++){
//            count++;
//            list.remove(0);
//            System.out.println(list+"  "+count);
//        }

//        while (!list.isEmpty()){
//            list.remove(0);
//            count++;
//            System.out.println(list+"  "+count);
//        }

//      not a good idea by using loop
//      loop removing can lead to logical confusion easily
//      except iterator
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
//            list.remove(iterator.next());//wrong exception cause-> modCount++ != exceptedModCount
            Integer next = iterator.next();
            if(next == 600){
                iterator.remove();
                continue;//avoiding repeatable 'if' analyzing problem
            }
            if (next == 600){
                iterator.remove();
                continue;
            }
        }

        System.out.println(list);
    }
}
