package w5_1;
import w4_1.*;
public class Manager extends Employee {
	private double bonus;
	public double getBonus() {
		return bonus;
	}
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	public Manager(int iNN, String name, String surname, 
				double salary, double bonus) {
		super(iNN, name, surname, salary);
		this.bonus = bonus;
	}
	@Override
	public double getSalary() {
		return (salary + bonus);
	}
	

}
