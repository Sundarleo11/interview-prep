import java.util.*;
import java.util.stream.Collectors;

public class StudentAverage {

    static class Student {
        private String name;
        private int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return name + "(" + age + ")";
        }
    }

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Alice", 20),
            new Student("Bob", 22),
            new Student("Charlie", 21),
            new Student("David", 23),
            new Student("Eve", 20)
        );

        // ✅ Method 1: Using Collectors.averagingInt
        double avgAge1 = students.stream()
                .collect(Collectors.averagingInt(Student::getAge));

        // ✅ Method 2: Using mapToInt().average()
        double avgAge2 = students.stream()
                .mapToInt(Student::getAge)
                .average()
                .orElse(0.0);

        System.out.println("Average age (Collectors): " + avgAge1);
        System.out.println("Average age (mapToInt): " + avgAge2);
    }
}
