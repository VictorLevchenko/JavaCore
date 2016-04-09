package w7_2;

import java.util.*;

public class Parking2 {
	private final int capacity; //max number of spots in parking
	public TreeMap<Integer, String> occupied = new TreeMap<>();
	
	public Parking2(int numberOfParkingSpots) {
		this.capacity = numberOfParkingSpots;
		}
	public int getCapacity() {
		return capacity;
	}
	public boolean checkIn(String s) {
		int pN = - 1;
		if((pN = findEmptySpot()) != - 1) {
			occupied.put(pN, s);
			return true;
		} else {
			return false;
		}
	}
	//return number of empty spot or -1 if there is no space
	private int findEmptySpot() {
		int spot = 0;
		if(occupied.size() == capacity) 
			return - 1;
		else {
			for(Integer k : occupied.keySet()) {
				if (k != spot)
					break;
				spot ++;
			}
		}
			return spot;
	}
	public String checkOut(int spotNumber) {
		for(Integer k: occupied.keySet()) {
			if(k == spotNumber) {
				occupied.remove(k);
				return occupied.get(k);
			}
		}
		return null;
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Integer k : occupied.keySet())
			sb.append(occupied.get(k) + " - " + k + ", ");
		return sb.toString();
	}
	public int getOccupiedSpace() {
				return occupied.size();
	}
	public int getFreeSpace() {
		return (getCapacity() - occupied.size());
	}
	
	public static void main(String[] args) {
		final int NUM = 10;
		Parking2 parking = new Parking2(NUM);
		Random rnd = new Random();
		for(int i = 0; i < 3; i++) {
			parking.checkIn("Car"); System.out.println("In *** " + parking);
			parking.checkIn("Car"); System.out.println("In *** " + parking);
			parking.checkIn("Car"); System.out.println("In *** " + parking);
			int n = rnd.nextInt(parking.getOccupiedSpace());
			parking.checkOut(n); System.out.println("Out from " + n + " *** " + parking);
			 n = rnd.nextInt(parking.getOccupiedSpace());
			parking.checkOut(n); System.out.println("Out from " + n + " *** " + parking);
		}

	}

}

