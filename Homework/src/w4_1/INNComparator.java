package w4_1;

import java.util.Comparator;

public class INNComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		if(o1.getiNN() == o2.getiNN())
			return 0;
		else if(o1.getiNN() > o2.getiNN())
			return 1;
		return -1;
	}
}
