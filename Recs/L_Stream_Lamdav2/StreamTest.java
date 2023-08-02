package WPackage;

import Vpackage.A_Pojo;
import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {


    public static void main(String[] args) {
        List<A_Pojo> list = new ArrayList<A_Pojo>(){{
            add(new A_Pojo("Aname",100));
            add(new A_Pojo("AAAAAname",100));
            add(new A_Pojo("BB_name",200));
            add(new A_Pojo("CCCname",300));
            add(new A_Pojo("d__name",300));
            add(new A_Pojo("d__name2",300));
        }};
        //filter
        list.stream().filter(a_pojo -> a_pojo.getAge()>200).forEach(System.out::println);
        //map
        list.stream().map(A_Pojo::getAge).forEach(System.out::println);
        //maptoobj
        IntStream.range(0,5).mapToObj(Integer::valueOf).forEach(System.out::println);
        ///boxed eg. only
        IntStream.range(0,5).boxed().map(Integer::doubleValue);
        System.out.println();
        //groupby age or etc... ...
        Map<Integer, List<A_Pojo>> collect = list.stream().collect(Collectors.groupingBy(A_Pojo::getAge));
        System.out.println(collect.get(100));
        //find
        Optional<Integer> any = list.stream().map(A_Pojo::getAge).filter(x -> x > 100).findAny();
        if (any.isPresent()) {
            System.out.println(any.get());
        }
        Integer integer = list.stream().map(A_Pojo::getAge).filter(x -> x > 10000000).findAny().orElse(400);
        System.out.println(integer+"nextline\n");
        //
        Integer integer1 = list.stream().map(A_Pojo::getAge).filter(x -> x > 100000).findFirst().orElseGet(() -> {
            return 404;
        });
        System.out.println(integer1);
        System.out.println();
        //
        Map<String, Supplier<Integer>> map = new HashMap<>();
        map.put("A",()->{return 0;});//eg
        //
        list.stream().map(x->0);//same
        list.stream().map(x-> {return 0;});//same
        //
        A_Pojo targetPojo = new A_Pojo("BB_name", 200);//need overwrite pojo eq&hash function
        int index = list.indexOf(targetPojo);
        System.out.println(index);//2
        // find element with loop,
        int targetage = 200;
        int indexlist = -1;
        for (int i=0;i< list.size();i++){
            A_Pojo aPojo = list.get(i);
            if (aPojo.getAge() == targetage){
                indexlist = -1;
                break;
            }
        }
        if (index !=-1){
            System.out.println(list.get(index));
        }else {
            System.out.println("no such element");
        }
        //lamda index confirm
        int asInt = IntStream.range(0, list.size()).filter(x -> list.get(x).getAge() == 300).findAny().getAsInt();
        System.out.println("int: "+asInt);
        //list to map
        Map<String, Integer> collect1 = list.stream().collect(Collectors.toMap(x -> x.getName(), x -> x.getAge()));
        System.out.println(collect1);
    }
}
