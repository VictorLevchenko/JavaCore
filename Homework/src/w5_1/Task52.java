package w5_1;

import static scannerUtil.NumberScanner.*;

import w4_1.*;

public class Task52 {

	public static void main(String[] args) {
		Company company = new Company("Fabrika");
		company.accept(new Manager(1000000001, "Глеб", "Свяжин", 2000, 50));
		company.accept(new Employee(1000000002, "Олег", "Стрельцов", 5000));
		company.accept(new Manager(1000000003, "Виктор", "Сотов", 3000, 100));
		company.accept(new Employee(1000000004, "Николай", "Пашковский", 2500));
		company.accept(new Employee(1000000005, "Андрей", "Сильчук", 2000));
		company.accept(new Employee(1000000006, "Андрей", "Брус", 5000));
		company.accept(new Employee(1000000007, "Антон", "Гриценко", 3000));
		company.accept(new Employee(1000000008, "Ольга", "Довганич", 2000));
		
		println(" Report in natural order\n");
		company.printReport(null);
		
		println(" Report sorted by INN\n");
		company.printReport(new INNComparator());
		
		println(" Report sorted by salary\n");
		company.printReport(new SalaryComparator());
		
		println("Total sallary for Company " +
		company.getName() + " = " + company.calculateSalary() + "\n");
		
		println("Minimum salary has \n");
		for(Employee e: company.findMinimumPaidEmployee())
			println(e);
		
		println("Maximum salary has \n");  
		for(Employee e: company.findMaximumPaidEmployee())
			println(e);
		
	}
}