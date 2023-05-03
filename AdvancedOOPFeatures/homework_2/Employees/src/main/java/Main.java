import java.util.Comparator;
import java.util.List;

public class Main {

    private static final String STAFF_TXT = "AdvancedOOPFeatures/homework_2/Employees/data/staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
        Employee employeeMaxSalary = findEmployeeWithHighestSalary(staff, 2017);
        System.out.println(employeeMaxSalary);
    }

    public static Employee findEmployeeWithHighestSalary(List<Employee> staff, int year) {
        return staff.stream()
                .filter(employee -> employee.getWorkStart().getYear() + 1900 == year)
                .max(Comparator.comparing(Employee::getSalary)).get();

    }
}