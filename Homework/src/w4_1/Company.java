package w4_1;

import static scannerUtil.NumberScanner.*;

import java.util.*;


public class Company {
	private Set<Employee> staff = new TreeSet<>();
	private String name;
	private Accountant accountant = new Accountant();
	public Company(String name) {
		this.setName(name);
	}
	private String makeReport (Comparator<Employee> comp) {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("%-20s%-20s%-20s%-20s\n", 
				"INN", "Name", "Surname", "Salary"));
		for (int i = 0; i < 80; i ++)
			sb.append('*');
		sb.append("\n");
		ArrayList<Employee> staffCopy = new ArrayList<>(staff);
		if(comp != null) {
			Collections.sort(staffCopy, comp);
		}
		for (Employee e: staffCopy) {
			sb.append(e);
			for (int i = 0; i < 80; i ++)
				sb.append('*');
			sb.append("\n");
		}
		return sb.toString();
	}
	public ArrayList<Employee> findMinimumPaidEmployee() {
		double sal = Double.MAX_VALUE;
		ArrayList<Employee> empl = new ArrayList<>();
		for (Employee e: staff) {
			if (e.getSalary() < sal) {
				empl.clear();
				empl.add(e);
				sal = e.getSalary();
			} else if(e.getSalary() == sal) {
				empl.add(e);
			}
		}
		return empl;
	}
	public ArrayList<Employee> findMaximumPaidEmployee() {
			double sal = Double.MIN_VALUE;
			ArrayList<Employee> empl = new ArrayList<>();
			for (Employee e: staff) {
				if (e.getSalary() > sal) {
					empl.clear();
					empl.add(e);
					sal = e.getSalary();
				} else if(e.getSalary() == sal) {
					empl.add(e);
				}
				
			}
			return empl;
	}
	public double calculateSalary() {
		
		Payable[] group = new Payable[staff.toArray().length]; 
		return accountant.sumSalary(this.staff.toArray(group));
	}
	public void printReport(Comparator<Employee> comp) {
		println(makeReport(comp));
	}
	public void accept(Employee employee) {
		staff.add(employee);
	}
	public void fire(Employee employee) {
		staff.remove(employee);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}