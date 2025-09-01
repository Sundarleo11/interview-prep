import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeGrouping  {

    static class Employee {
        private String name;
        private int age;

        public Employee(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        public Employee setAge(int age) {
            this.age = age;
            return this;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 25),
                new Employee("Bob", 30),
                new Employee("Charlie", 25),
                new Employee("David", 30),
                new Employee("Eve", 35),
                new Employee("Frank", 25)
        );

        // ✅ Group by age
        Map<Integer, List<Employee>> groupedByAge = employees.stream()
                .collect(Collectors.groupingBy(Employee::getAge));

        groupedByAge.forEach((age, empList) ->
                System.out.println(age + " -> " + empList));
    }
}
