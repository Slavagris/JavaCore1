package Homework9;
/**
 * JavaCore package Homework1
 *
 * @author Slava Grishin
 * version 24.01.2022
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Slava", Arrays.asList(new Course("Math"), new Course("Biology"),
                new Course("Testing"))));
        students.add(new Student("Vlad", Arrays.asList(new Course("Math"), new Course("Geography"),
                new Course("Testing6"), new Course("Testing2"))));
        students.add(new Student("Masha", Arrays.asList(new Course("Physics"), new Course("Biology"),
                new Course("Testing"), new Course("Testing1"))));

        //1
        System.out.println(students.stream()
                .map(s -> s.getCourses())
                .flatMap(f -> f.stream())
                .collect(Collectors.toSet()));

        //2
        System.out.println(students.stream()
                .sorted((s1, s2) -> s2.getCourses().size() - s1.getCourses().size())
                .limit(2)
                .collect(Collectors.toList()));

        //3
        Course course = new Course("Testing");
        System.out.println(students.stream()
                .filter(s -> s.getCourses().contains(course))
                .collect(Collectors.toList()));
    }
}
