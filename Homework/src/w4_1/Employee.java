package w4_1;

import java.util.Comparator;

public class Employee implements Comparable<Employee>, Payable {
	private long iNN;
	private String name, surname;
	protected double salary;
	public static Comparator<Employee> iNNComparator = new Comparator<Employee>() {
		@Override
		public int compare(Employee o1, Employee o2) {
			if(o1.getiNN() == o2.getiNN())
				return 0;
			else if(o1.getiNN() > o2.getiNN())
				return 1;
			return -1;
		}
	};
	public static Comparator<Employee> salaryComparator = new Comparator<Employee>() {
		@Override
		public int compare(Employee o1, Employee o2) {
			if(o1.getSalary() == o2.getSalary())
				return 0;
			else if(o1.getSalary() > o2.getSalary())
				return 1;
			return -1;
		}
	};
	public Employee (int iNN, String name, String surname, 
			double salary) {
		this.setiNN(iNN);
		this.setName(name);
		this.setSurname(surname);
		this.setSalary(salary);
	}
	public String toString() {
		return String.format("%-20d%-20s%-20s%-20.2f\n", 
				getiNN(), getName(), getSurname(), getSalary());
	}
	
	public long getiNN() {
		return iNN;
	}
	public void setiNN(long iNN) {
		this.iNN = iNN;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	//TODO: bad decision to choose name + surname as natural ordering
	//it's better to make INN primary key and sort by PK
	@Override
	public int compareTo(Employee o) {
		
		return (name + surname).compareToIgnoreCase(o.name + o.surname);
	}
}
