import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args){
        List<String>names = Arrays.asList("MIsha", "Mike", "Beata", "Maryna", "Antonina", "Yana", "Vlada");
        System.out.println(Exercise1(names));

        System.out.println(Exercise2(names));

        String[] arr3 = {"1, 2, 0", "4, 5"};
        System.out.println(Exercise3(arr3));


        RandomAlg ra = new RandomAlg();
         Stream <Integer> iterate = Stream.iterate(11,(seed) -> ra.whithSeed(seed).next());
         iterate.peek(System.out::println)
                 .limit(10)
                 .collect(Collectors.toList());




         Stream<Integer> stream1 = Stream.of(1, 2, 3);
        Stream<Integer> stream2 = Stream.of(4, 5, 6);

        Stream<Integer> randomlyMergedStream = zip(stream1, stream2);

        randomlyMergedStream.forEach(System.out::println);





    }

    public static String Exercise1 (List <String> names){
        Stream<String> nameString = names.stream();
        return IntStream.range(0, names.size())
                .filter(i -> i % 2 != 0)
                .mapToObj(i -> (i) + ". " + names.get(i))
                .collect(Collectors.joining(", "));
    }


    public static List<String> Exercise2(List<String> names){
        Stream<String> nameString = names.stream();
        return nameString.map(String :: toUpperCase)
                .sorted((s1, s2) -> s2.compareTo(s1))
                .collect(Collectors.toList());

    }
    public static String Exercise3(String [] arr){
        String arrAsString = Arrays.stream(arr)
                .collect(Collectors.joining(", "));
        String result = Arrays.stream(arrAsString.split(", "))
                .map(Integer::parseInt)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        return result;

    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second){
        List<T> list1 = first.collect(Collectors.toList());
        List<T> list2 = second.collect(Collectors.toList());

        Collections.shuffle(list1);
        Collections.shuffle(list2);

        return Stream.concat(list1.stream(), list2.stream());
    }
    }

