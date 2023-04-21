import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class main1 {
    public static void main(String[] args) {
        Random rnd = new Random();
        double random = rnd.nextDouble(50000, 100000);
        Company company = new Company();
        for (int i = 0; i < 180; i++) {
            company.hire(new Operator(random));
        }
        for (int i = 0; i < 80; i++) {
            company.hire(new Manager(random));

        }
        for (int i = 0; i < 10; i++) {
            company.hire(new TopManager(random, company));
        }
        Scanner scn = new  Scanner(System.in);
        int input = 0;
        while (input != 4) {
            System.out.println("""
                    1. Распечатайте список из 15 самых высоких зарплат в компании.
                    2. Распечатайте список из 30 самых нихких зарплат в компании.
                    3. Увольте 50% сотрудников.
                   """);
            input = scn.nextInt();
            switch (input){
                case 1 -> System.out.println(company.getTopSalaryStaff(15));
                case 2 -> System.out.println(company.getLowestSalaryStaff(30));
                case 3 -> {
                    List<Employee> employees = company.getEmployees();
                    for (int i = 0; i < 135; i++) {
                        company.fire(employees.get(i));
                    }
                }
                default -> System.out.println("Введено не правильное значение");
            }
        }
    }
}
