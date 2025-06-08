package Steam_assignment;

import java.util.Arrays;
import java.util.stream.Collectors;

public class question2 {
    public static void main(String[] args) {
        String s = "Hellothisisatrialstring";
        System.out.println(Arrays.stream(s.split("")).
                collect(Collectors.groupingBy(c-> c, Collectors.counting())));

    }
}
