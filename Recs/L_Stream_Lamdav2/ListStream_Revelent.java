package WPackage;

import Vpackage.A_Pojo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListStream_Revelent {
    public static void main(String[] args) {
        List<A_Pojo> list = new ArrayList<A_Pojo>(){{
            add(new A_Pojo("Aname",100));
            add(new A_Pojo("BB_name",200));
            add(new A_Pojo("CCCname",300));
            add(new A_Pojo("d__name",300));
            add(new A_Pojo("EEE__name",40000));
            add(new A_Pojo("fff__name",500));
        }};

        List<A_Pojo> list2 = new ArrayList<>();
        for (A_Pojo aPojo:list){
            System.out.println(aPojo);
            if (aPojo.getAge()>200){
                list2.add(aPojo);
            }
        }
        System.out.println(list2+"\n");

        //improved by Stream
        list.stream().filter(a_pojo -> a_pojo.getAge()>200).forEach(System.out::println);
        System.out.println();
        //skip function test
        list.stream().skip(2).limit(3).forEach(System.out::println);
        System.out.println();
        //get age test
        list.stream().map(A_Pojo::getAge).forEach(System.out::println);
        //compare
        list.stream().sorted((o1, o2) -> o1.getAge()-o2.getAge()).forEach(a_pojo -> System.out.println(a_pojo.getAge()));

    }
}
