import java.util.*;
import java.util.stream.Collectors;

public class MultiFieldSort {

    static class Student {
        private String name;
        private int age;
        private double grade;

        public Student(String name, int age, double grade) {
            this.name = name;
            this.age = age;
            this.grade = grade;
        }

        public String getName() { return name; }
        public int getAge() { return age; }
        public double getGrade() { return grade; }

        @Override
        public String toString() {
            return name + " (Age: " + age + ", Grade: " + grade + ")";
        }
    }

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Alice", 22, 85.5),
            new Student("Bob", 20, 91.0),
            new Student("Charlie", 22, 78.0),
            new Student("David", 20, 91.0),
            new Student("Eve", 21, 85.5)
        );

        List<Student>sortedStudents=students.stream().sorted(Comparator.comparing(Student::getAge).thenComparing(Comparator.comparingDouble(Student::getGrade).reversed()).thenComparing(Student::getName)).collect(Collectors.toList());

        sortedStudents.forEach(System.out::println);
    }
}
