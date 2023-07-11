package ComparableTorPractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest {
    public static void main(String[] args) {

        List<Long> list = new ArrayList();
        list.add(100L);
        list.add(2L);
        list.add(3L);
        list.add(-1003L);
//        Collections.sort(list, new Comparator<Long>() {
//            @Override
//            public int compare(Long o1, Long o2) {
//                return Long.compare(o1,o2);
//            }
//        });
        Collections.sort(list,((Long o1,Long o2) -> Long.compare(o1,o2)));
        System.out.println(list);
    }

}
