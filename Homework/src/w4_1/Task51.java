package w4_1;

import static scannerUtil.NumberScanner.*;

/*51. В компании "Фабрика Од Уа, ЛТД" работает 10 человек. 
 * Используя класс Employee написать программу, которая создает 
 * список (массив) из 10 элементов и заполняет его данными о сотрудниках
 *  компании. Главбух компании очень любит различные красивые отчеты
 *   и статистику. Для того, чтобы сделать работу главбуха веселее,
 *    а себе выбить возможность получения бонусов, реализовать
 *     в программе следующие функции:
 *a. Печать отчета в виде: INN	ФИО	зряплата
 *b. Вычислить ежемесечное количество денег, которое главбух должен 
 *оторвать от фонда заработной платы для выдачи сотрудникам.
 *c. Вычислить сотрудника с минимальным окладом. Распечатать в виде:
 * INN	ФИО	зряплата
 *d. Вычислить мажора с максимальным окладом. Распечатать в виде:
 *    INN	ФИО	зряплат
 *Note: Класс Employee должен содержать следующую информацию о 
 *сотруднике - INN, Name, Surname, Salary
 */	
public class Task51 {

	public static void main(String[] args) {
		Company company = new Company("Fabrika");
		company.accept(new Employee(1000000001, "Глеб", "Свяжин", 2000));
		company.accept(new Employee(1000000002, "Олег", "Стрельцов", 5000));
		company.accept(new Employee(1000000003, "Ronald", "Monks", 3000));
		company.accept(new Employee(1000000004, "Bill", "Gates", 1000));
		
		company.printReport(null);
		
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



