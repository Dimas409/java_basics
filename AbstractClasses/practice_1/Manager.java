

public class Manager  implements Employee{
    private final double salary;
    private final double incomeOfOneManager = 115000 + Math.random() * 25000;

    public Manager(double salary) {
        this.salary = salary + (0.05 * getIncomeOfOneManager());


    }

    public double getIncomeOfOneManager() {
        return incomeOfOneManager;
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
