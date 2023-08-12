package WPackage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest_Third {
    public static void main(String[] args) {
       Map map = new HashMap<>();
       map.computeIfAbsent("hello",new B_Pojo("name",100));
       map.getOrDefault("hello",new B_Pojo("name",100));
       System.out.println(map);


        List list1 = List.of(4,5,6);//4,5,6 -->>>[1,2][1,2][1,2]
        List list2 = List.of(1,2);
//        list1.stream().map(x -> list2.stream().collect(Collectors.toList())).forEach(System.out::println);
        System.out.println(list1.stream().flatMap(x->list2.stream().map(y -> x+"+"+y)).collect(Collectors.toList()));
    }
}
