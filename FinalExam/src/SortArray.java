import java.util.Arrays;
import java.util.Comparator;

/**Имеется  массив объектов сотрудников:

	public class Employee {
    public String extension;
    public String name;
    public String surname;

}

Воспользуйтесь стандартными пакетами сортировки для упорядочивания элементов
 массива, сначала по фамилиям, а затем по именам.
 */
public class SortArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee[] array = {new Employee("mr", "jon", "smith"), new Employee("mr", "bill", "smith"),
				new Employee("ms", "barbara", "lane"), new Employee("mr", "jon", "travolta")};
		array = sortByName(array);
		System.out.println(Arrays.toString(array));
	}
	static Employee[] sortByName(Employee[] array) {
		Arrays.sort(array, new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				int result =  o1.surname.compareTo(o2.surname);
				return (result != 0) ? result: o1.name.compareTo(o2.name); 
			}
			
			
		});
		return array;
	}
	
}
class Employee {
    public String extension;
    public String name;
    public String surname;
    public Employee(String ext, String name, String surname) {
    	this.extension = ext;
    	this.name = name;
    	this.surname = surname;
    }
    public String toString() {
    	return extension + " " + surname + " " + name;
    }

}