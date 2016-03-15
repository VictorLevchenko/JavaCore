package w5_1;

import static scannerUtil.NumberScanner.*;
import w4_1.*;
/*52. Из 10 сотрудников "Фабрика Од Уа, ЛТД" 5 - управленцы среднего звена. 
 * Используя класс Employee как базовый, создать класс FabrikaManager для хранения 
 * информации о сотрудниках-управляющих. Добавить возможность установки бонуса для 
 * менеджеров и обеспечить соответствующий расчет зарплаты с учётом бонуса. Реализовать
 *  пункты a-d для всех сотрудников компании, т.е. учитывая и управляющих, и обычных 
 *  сотрудников. Реализовать возможность сортировки списка сотрудников по любому полю
 *   из класса Employee. Натуральная сортировка - алфавитный порядок имени-фамилии 
 *   вместе.
 */
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
		company.printReport(Employee.iNNComparator);
		
		println(" Report sorted by salary\n");
		company.printReport(Employee.salaryComparator);
		
		println("Total sallary for Company " +
		company.getName() + " = " + company.calculateSalary() + "\n");
		
		println("Minimum salary have \n");
		for(Employee e: company.findMinimumPaidEmployee())
			println(e);
		
		println("Maximum salary have \n");  
		for(Employee e: company.findMaximumPaidEmployee())
			println(e);
		
	}
}