

public class Manager  implements Employee{
    private  double salary;
    private Company company;
    private  double bonus = 0.05 *(115000+ (Math.random() * 25000));
    public Manager(double salary, Company company) {
        this.salary = salary + bonus;
        company.setIncome(115000+ (Math.random() * 25000));

    }
    @Override
    public double getMonthSalary() {
        return salary;
    }

    public String toString() {
        return getClass().getName() +
                " зарплата: " + Math.round(salary) + " руб." + "\n";
    }
}
