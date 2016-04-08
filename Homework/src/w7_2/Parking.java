package w7_2;

import java.util.*;

public class Parking {
	private final int capacity; //max number of spots in parking
	public TreeSet<Car> occupied = new TreeSet<>();
	
	public Parking(int numberOfParkingSpots) {
		this.capacity = numberOfParkingSpots;
		}
	public int getCapacity() {
		return capacity;
	}
	public boolean checkIn(String s) {
		Car car = new Car(s);
		int pN = - 1;
		if((pN = findEmptySpot()) != - 1) {
			car.setSpot(pN);
			occupied.add(car);
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
			
			Iterator<Car> it = occupied.iterator();
			while(it.hasNext()) {
				if (it.next().getSpot() != spot) 
					break; 
				spot ++;
			}
		}
			return spot;
			
	}
	public String checkOut(int spotNumber) {
		for(Car c: occupied) {
			if(c.getSpot() == spotNumber) {
				occupied.remove(c);
				return c.getPlate();
			}
		}
		return null;
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Car c : occupied)
			sb.append(c.getPlate() + " - " + c.getSpot() + ", ");
		return sb.toString();
	}
	public int getOccupiedSpace() {
				return occupied.size();
	}
	public int getFreeSpace() {
		return (getCapacity() - occupied.size());
	}
	
	private class Car  implements Comparable<Car> {
		private String plate;
		private int spot; // spot in parking
		Car(String number) {
			setPlate(number);
		}
		public String getPlate() {
			return plate;
		}
		public void setPlate(String plate) {
			this.plate = plate;
		}
		public int getSpot() {
			return spot;
		}
		public void setSpot(int spot) {
			this.spot = spot;
		}
		@Override
		public int compareTo (Car c) {
			int nSThis = getSpot();
			int nS = c.getSpot();
			return (nSThis == nS) ? 0 : (nSThis - nS); 
		}
		
	}
	public static void main(String[] args) {
		final int NUM = 10;
		Parking parking = new Parking(NUM);
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
