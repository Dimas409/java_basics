public class TopManager implements Employee{

    private final double salary;
   private Company company ;

    public TopManager(double salary, Company company) {
        this.salary = salary * (company.getIncome() >= 10_000_000 ? 1.5 : 1);
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
