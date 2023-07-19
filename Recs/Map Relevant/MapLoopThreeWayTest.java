package MapPractice;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapLoopThreeWayTest {
    public static void main(String[] args) {
        //Map.newHashMap()
        Map<String,String> hm = new HashMap<>(){{
            //{{}}
            put("A","1");
            put("B","2");
            put("C","3");
            put("D","4");
        }};


        Set keys = hm.keySet();
        Iterator iterator = keys.iterator();
        System.out.println("while loop");
        while (iterator.hasNext()){
            Object key = iterator.next();
            System.out.println("key:"+key+"  value:"+hm.get(key));
        }

        System.out.println("foreach");
        for (Object obj:keys){
            System.out.println("key:"+obj+"  value:"+hm.get(obj));
        }

        System.out.println("recommend using this");
        //recommend using this
        for (Map.Entry<String,String> entry: hm.entrySet()){
            System.out.println(entry.getKey()+"  "+entry.getValue());
        }
    }
    
}
