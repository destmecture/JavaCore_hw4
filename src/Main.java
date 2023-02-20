
import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Integer[] array1 = new Integer[10];
        for (int i = 0; i < array1.length; i++) {
            array1[i]= new Random().nextInt(100);
        }
        List<Integer> list = Arrays.asList(array1);        //Создаем список произвольных чисел
        System.out.println(list);                          //Проверяем сгенерированные числа


        Stream<Integer> stream = list.stream();
        Comparator<Integer> order = Comparator.naturalOrder();
        BiConsumer<Integer, Integer> biConsumer = (min, max) -> System.out.println(min + " - мин. значение, "
                + max + " - макс. значение");


        findMinMax(stream, order, biConsumer);
        findNumberOfEvens(list);

    }


    public static void findMinMax(
            Stream<Integer> stream,
            Comparator<Integer> order,
            BiConsumer<Integer, Integer> minMaxConsumer) {
        List<Integer> list = stream.collect(Collectors.toList());
        if (list.isEmpty()) {
            minMaxConsumer.accept(null, null);
        }else{
            list.sort(order);
            minMaxConsumer.accept(list.get(0), list.get(list.size()-1));
        }
    }
    public static void findNumberOfEvens(List<Integer> list){
        Stream<Integer> stream = list.stream();
        System.out.println(stream.filter((n) -> (n % 2) == 0)
                .count()+" - количество четных числел в списке");
    }
}