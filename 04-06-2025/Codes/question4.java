package Steam_assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class student{
    String name;
    String gender;

    student(String name, String gender){
        this.name = name;
        this.gender = gender;
    }

}

public class question4 {
    public static void main(String[] args) {
        List<student> l1 = Arrays.asList(new student("Aman", "Male"),
                new student("Sanskar", "Female"),
                new student("Dixit", "Male"),
                new student("Khushi", "Female"));

        l1.stream().map(student -> {
            String p = student.gender.equals("Male") ?  "Mr. " : "Ms. ";
            return p + student.name;
        }).collect(Collectors.toList()).forEach(System.out::println);
    }
}
