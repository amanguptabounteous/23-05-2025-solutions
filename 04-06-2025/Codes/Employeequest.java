package Steam_assignment;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Employeequest {
    public static void main(String[] args) {
        List<String> hr = Arrays.asList("Naman", "Saloni", "Aditi");
        List<String> engineering = Arrays.asList("Aman", "Abhishek", "Dixit", "Manan");
        List<String> sales = Arrays.asList("Sanskar", "Jhanvi", "Khusagra");
        List<String> emp = Stream.of(hr, engineering, sales).flatMap(List::stream).collect(Collectors.toList());
        Map<Character, List<String>> gs = emp.stream().collect(Collectors.groupingBy(s -> s.charAt(0)));
        System.out.println(gs);


    }
}
