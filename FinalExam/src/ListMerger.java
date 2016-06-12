import java.util.*;

/**Главный доменный контроллер получает от доменных контроллеров отделов 
 *список всех учетных записей, упорядоченых по идентификаторам пользователей.
 *Реализуйте класс, комбинирующий эти данные в единый список, упорядоченый 
 *по идентификаторам пользователей. 
 */
public class ListMerger extends TreeSet<Account> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//List list1 = new ArrayList({"1")
		Account[] list1 = {new Account(1, "1"), new Account(3, "3")};
		Account[] list2 = {new Account(2, "2"), new Account(4, "4")};
		ListMerger mainList = new ListMerger();
		mainList.addAll(Arrays.asList(list1));
		mainList.addAll(Arrays.asList(list2));
		System.out.println(mainList);
		//mainList.
	}

}

class Account implements Comparable<Account> {
	public int id;
	public String password;
	public Account(int id, String password) {
		this.id = id;
		this.password = password;
	}
	@Override
	public int compareTo(Account o) {
	
		return (this.id == (o.id)) ? 0 : (this.id - o.id); 

	}
	@Override
	public String toString() {
		return "id = " + id + ", pasword = " + password;
	}
}