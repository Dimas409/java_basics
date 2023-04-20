import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Company {
    private int income;
    private List<Employee> employees;
    public Company(){
        employees = new ArrayList<>();
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public List<Employee> getTopSalaryStaff(int count){
        if(count< 0){
            System.out.println("Передано отрицательное значение");
            return Collections.emptyList();
        }
        if (count > employees.size()){
            count = employees.size();
        }
        Collections.sort(employees);
        Collections.reverse(employees);
        List<Employee> companyTopSalary = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            companyTopSalary.add(employees.get(i));
        }
        return companyTopSalary;
    }
    public ArrayList<Employee> getLowestSalaryStaff(int count){
        Collections.sort(employees);
        ArrayList<Employee> lowestSalaryStaff = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lowestSalaryStaff.add(employees.get(i));
        }
        return lowestSalaryStaff;
    }
    public void hire(Employee employee){

        employees.add(employee);
    }
    public void hereAll(Collection<Employee> employees){
        for (Employee e: employees){
            hire(e);
        }
    }
    public void fire(Employee employee){
        employees.remove(employee);
    }

    public void setIncome(double bonus) {
        this.income += bonus;
    }

    public int getIncome() {
        return income;
    }
}
