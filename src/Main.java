import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        findMinMax(Stream.of(1, 2, 3, 4, 65454, -2, 65458, 6), Integer::compareTo, (min, max) -> {
            System.out.printf("min: %d, max: %d", min, max);
        });

        System.out.println();

        List <Integer> list = new ArrayList<>();
        int[] x = {45, 85, 26, 45, 358, 65, 87, 528, 222, 24,};
        for (Integer integer : x) {
            list.add(integer);
        }
        System.out.println(evenNumbers(list));
    }

    private static <T> void findMinMax(Stream<? extends T> stream,
                                       Comparator<? super T> comparator,
                                       BiConsumer<? super T, ? super T> consumer) {
        List<T> list = stream.sorted(comparator).collect(Collectors.toList());
        consumer.accept((list.get(0)), list.get(list.size() - 1));
    }

    private static List<Integer> evenNumbers(List<Integer> number) {
        List<Integer> list = number.stream()
                .filter(num -> num % 2 == 0)
                .toList();
        return Collections.singletonList(list.size());
    }
}