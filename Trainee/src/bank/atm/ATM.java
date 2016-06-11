package bank.atm;

import java.util.*;
/*
 * Simple ATM simulation program
 * for simplicity using int for money 
 */
public class ATM {
	enum State { INIT, GET_MONEY, GET_MONEY_OPTION,
		REPORT, ATM_EMPTY}
	private static State state = State.INIT;
	private static Account account;
	//map to hold banknotes in pairs (banknote, amount)
	private TreeMap<Integer, Integer> bankNotes = new TreeMap<>(Collections.reverseOrder());
	
	public static void main(String[] args) {
		
		ATM atm = new ATM();
		account = new Account(1000);
		atm.fill(5, 1);
		atm.fill(10, 1);
		atm.fill(20, 1);
		atm.fill(50, 1);
		atm.fill(100, 1);
		atm.fill(200, 1);
		atm.fill(500, 1);
		
		Scanner in = new Scanner(System.in);
		List<Integer> listNotes = null;
		while(true) {
			switch (state) {
			 
				case INIT:
				
					if(atm.isEmpty()) {
						System.out.println(" Sorry, we are run out of money");
						state = State.ATM_EMPTY;
					}
					System.out.println();
					System.out.println(
							"Please choose:\n" +
							"1 - report\n" + 
							"2 - get money\n" + 
							"Input(1 or 2): ");
					int  a = in.nextInt();
					if(a == 1) {
						state = State.REPORT;
					}
					if( a == 2) {
						state = State.GET_MONEY;
					}
				
				break;
				case GET_MONEY:
				
					System.out.println(
							"How much money do you want? : ");
					int amount = in.nextInt();
					if(!account.insureEnoughMoney(amount)) {
						System.out.println("You don't have enough money on your account");
						state = State.INIT;
						break;
					} else {
						listNotes = atm.trySatisfyDemand(amount);
						if(atm.totalCash(listNotes) == amount) {
							System.out.println(" Please get your money");
							System.out.println(atm.withdraw(amount));
							account.withdraw(amount);
							state = State.INIT;
							break;
						} else {
							state = State.GET_MONEY_OPTION;
							break;
						}
					}
				case GET_MONEY_OPTION:
					
					int minCash = atm.totalCash(listNotes);
					int maxCash = minCash + atm.findMinimumAvailableNote();
					System.out.print(
							"Sorry, we can't give you your demand \n" +
							"We suggest to get following "
					);
					if(minCash != 0)
						System.out.print(minCash + " ");
					if(maxCash != 0 && maxCash != minCash && maxCash < atm.totalCash())
						System.out.println(maxCash);
					state = State.INIT;
				break;
			case REPORT:
				atm.printBankNotesReport();
				account.printBalance();
				state = State.INIT;
				break;
			case ATM_EMPTY:
				//dead state
				break;
			default:
				//unknown state
			}
		}

	}
	//fill ATM with bank notes
	public void fill (int banknote, int amount) {
		
		bankNotes.put(banknote, amount);
	}
	// calculate the amount of money in ATM
	public int totalCash() {
		int sum = 0;
		for (Integer nk: bankNotes.keySet()) {
			sum += (nk * bankNotes.get(nk));
		}
		return sum;
	}
	//calculate amount of money in list of banknotes
		public int totalCash(List<Integer> list) {
			
			int result = 0;
			for (int a : list) {
				result += a;
			}
			return result;
		}
	//check if ATM is empty
	public boolean isEmpty() {
		return (totalCash() == 0);
		
	}
	public void printBankNotesReport() {
		System.out.println("BankNotes in ATM:");
		for (Integer nk: bankNotes.keySet()) {
			System.out.println(nk + " - " + bankNotes.get(nk));
		}
		System.out.println("Total cash: " + totalCash());
	}
	//find bank note with minimum nominal
	private int findMinimumAvailableNote() {
		
		TreeMap<Integer, Integer> newBankNotes = new TreeMap<>(bankNotes);
		for (Integer nk: newBankNotes.descendingKeySet()) {
			if(newBankNotes.get(nk) != 0) return nk;
		}
		return 0;
	}
	// give money to customer and update his account
	//return list of banknotes
	public List<Integer> withdraw(int amount) {
		List<Integer> noteList = new ArrayList<>();
		for (Integer nk: bankNotes.keySet()) {
			int quantity = bankNotes.get(nk);
			while((quantity != 0) && (amount >= nk)) {
				amount -= nk;
				bankNotes.put(nk, -- quantity); //decrease amount of notes
				noteList.add(nk);
			}
		}
		account.withdraw(amount); //update account
		return noteList;
	}
	//return list of notes from ATM that is lower or equal to demand
	public List<Integer> trySatisfyDemand(int amount) {
		List<Integer> noteList = new ArrayList<>();
		TreeMap<Integer, Integer> newBankNotes = new TreeMap<>(bankNotes);
		for (Integer nk: newBankNotes.keySet()) {
			int quantity = newBankNotes.get(nk);//System.out.println(curBankNote);
			while((quantity != 0) && (amount >= nk)) {
				amount -= nk;
				newBankNotes.put(nk, -- quantity); //decrease amount of notes
				noteList.add(nk);
			}
		}
		return noteList;
	}
}
//simple class for costumer's account
class Account {
	private int balance;
	
	public Account(int balance) {
		this.balance = balance;
	}

	public int getBalance() {
		return balance;
	}
	public boolean withdraw(int amount) {
		if(insureEnoughMoney(amount)) {
			balance -= amount;
			return true; //sucess
		}
		return false; //unsecessful operation
	}
	public boolean insureEnoughMoney(int amount) {
		return (balance >= amount);
	}
	public void printBalance() {
		System.out.println("Account balance: " + balance);
	}

}
