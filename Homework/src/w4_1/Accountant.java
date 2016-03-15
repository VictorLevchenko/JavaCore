package w4_1;

public class Accountant {
	double sumSalary(Payable[] group) {
		double sal = 0.0;
		for (Payable e: group)
			sal += e.getSalary();
		return sal;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
