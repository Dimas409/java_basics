import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static final String STAFF_TXT = "/home/dmitry/IdeaProjects/java_basics/AdvancedOOPFeatures/homework_1/data/staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
        staff.sort(Comparator.comparing(Employee::getName));
        sortBySalaryAndAlphabet(staff);

        System.out.println(staff);
    }

    public static void sortBySalaryAndAlphabet(List<Employee> staff) {
        staff.sort(Comparator.comparing(Employee::getName));
        staff.sort(Comparator.comparing(Employee::getSalary));
    }
}