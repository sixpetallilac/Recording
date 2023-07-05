package Setspractices;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SetwithListEG {
    public static void main(String[] args) {
        Set s1 = new HashSet();
        s1.add('a');
        s1.add('z');

        Set s2 = new TreeSet();
        s2.add('a');
        s2.add('b');

        s1.removeAll(s2);
        System.out.println(s1);

        List<String> list = Lists.newArrayList();//recommend using static function
        Set sn = Sets.newHashSet();
    }
}
