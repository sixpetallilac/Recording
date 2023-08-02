package WPackage;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SteamTest_sec {
    public static void main(String[] args) {
        Stream<Integer> stream = List.of(1, 2, 3, 4, 5).stream();
        boolean boo = stream.noneMatch(x -> x < 1);
        System.out.println(boo);
        Integer integer = List.of(1, 2, 3, 4, 5).parallelStream().reduce(Integer::sum).get();
        System.out.println(integer);

        List<Integer> list = List.of(4, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        OptionalInt first = IntStream.range(0, list.size()).filter(x -> list.get(x) == 4).findAny();
        System.out.println(first.getAsInt());
    }
}
