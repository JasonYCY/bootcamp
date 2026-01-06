import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DemoStreamMap {
  // inner static class
  public static class Employee {
    private String name;
    private String department;
    private int salary;

    public Employee(String name, String department, int salary) {
      this.name = name;
      this.department = department;
      this.salary = salary;
    }

    public String getName() {
      return name;
    }

    public String getDepartment() {
      return department;
    }

    public int getSalary() {
      return salary;
    }

    public String toString() {
      return "Employee{name=" + name + ", department=" + department + ", salary=" + salary + "}";
    }
  }



  // main method
  public static void main(String[] args) {
    // test
    List<Employee> employees = Arrays.asList(
      new Employee("John", "IT", 21000),
      new Employee("Sally", "HR", 19000),
      new Employee("Mary", "IT", 35000),
      new Employee("Dicky", "HR", 28000),
      new Employee("Leo", "MK", 34000),
      new Employee("Oscar", "IT", 39000)
    );

    Map<String, List<Employee>> departmentToEmployeeListMap = employees.stream()
      .collect(Collectors.groupingBy(
        Employee::getDepartment
      ));

    departmentToEmployeeListMap.forEach(
      (key, value) -> {
        System.out.println("Key: " + key + " | Value: " + value);
      }
    );

    Map<String, Integer> salaryMap = employees.stream()
      .collect(Collectors.groupingBy(
        Employee::getDepartment,
        Collectors.summingInt(Employee::getSalary)
      ));
    System.out.println(salaryMap);

    Map<Boolean, List<Employee>> salaryGroup = employees.stream()
      .collect(Collectors.partitioningBy(
        employee -> employee.getSalary() >= 30000
      ));
    System.out.println(salaryGroup);

    // Version 1
    // System.out.println("Salary >= 30000:");
    // salaryGroup.get(true).forEach(employee -> System.out.println("\t" + employee));
    // System.out.println();
    
    // System.out.println("Salary < 30000:");
    // salaryGroup.get(false).forEach(employee -> System.out.println("\t" + employee));
    // System.out.println();
    
    // Version 2
    // salaryGroup.entrySet().forEach(entry -> {
    //   System.out.println("\nKey:\t" + entry.getKey());
    //   System.out.print("Value: ");
    //   entry.getValue().forEach(employee -> System.out.println("\t" + employee));
    // });

    // Version 3
    salaryGroup.forEach((key, value) -> {
      System.out.println("\nKey:\t" + key);
      System.out.print("Value: ");
      value.forEach(employee -> System.out.println("\t" + employee));
    });









  }
}
