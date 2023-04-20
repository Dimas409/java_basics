public interface Employee extends Comparable<Employee>{
    double getMonthSalary();

    @Override
    default int compareTo(Employee employee){
        return Double.compare(getMonthSalary(), employee.getMonthSalary());
    }
}
