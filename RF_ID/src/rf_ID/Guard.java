package rf_ID;


import java.util.*;

public class Guard {
	enum CheckStatus {
		OK,
		NOT_AUTORISED,
		ALREADY_IN,
		ALREADY_OUT,
		EMPTY_BUILDING,
		UNKNOWN
	}
	private List<String> insiderList;
	DatabaseHandler database;
	public Guard() {
		
		database = new DatabaseHandler();
		insiderList = database.getListIn();
	}
	void loadInsiderList() {
		insiderList = database.getListIn();
	}
	String getLog() {
		return database.getLog();
	}
	void clearLog() {
		database.clearLog();
		insiderList = database.getListIn();
	}
	String getName(String card) {
		return database.getName(card);
	}
	String getPersonId(String card) {
		return database.getPersonId(card);
	}
	CheckStatus check(String message) {
		//parse message from device
		String card = message.substring(1,12); // get id string
		String direction = message.substring(13); //get in or out
		CheckStatus result = CheckStatus.UNKNOWN;
		boolean allowed = database.isRegistered(card);
		boolean inside = insiderList.contains(card);
		boolean empty = insiderList.isEmpty();
		if(!allowed) return CheckStatus.NOT_AUTORISED;
		switch(direction) {
		case "IN":
			if(!inside) {
				result = CheckStatus.OK;
				insiderList.add(card);
			}
			else 
				result = CheckStatus.ALREADY_IN;
			break;
		case "OUT":
			if(inside && !empty) {
				result = CheckStatus.OK;
				insiderList.remove(card);
			}
			else if(empty)
				result = CheckStatus.EMPTY_BUILDING;
			else if(!inside)
				result = CheckStatus.ALREADY_OUT;
			break;
		default:
			break;
		}
		if(result == CheckStatus.OK) {
			database.saveEntry(card, direction);
		}
		return result;
	}
	int numberOfPeopleInside() {
		return insiderList.size();
	}
	byte[] getPhoto(String person_id) {
		return database.getPhoto(person_id);
	}
	void setPhoto(String person_id, String pathToImage) {
		database.setPhoto(person_id,pathToImage);
	}
	public static void main(String[] args) {
		
		Guard guard = new Guard();
		System.out.println(guard.numberOfPeopleInside());
		System.out.println(guard.check(" 9B 93 9A E4 IN")); //not autorised
		System.out.println(guard.numberOfPeopleInside());
		System.out.println(guard.check(" 9B 93 9A E5 IN")); //already in
		System.out.println(guard.numberOfPeopleInside());
		System.out.println(guard.check(" CC 03 A8 E5 OUT")); // already out
		System.out.println(guard.numberOfPeopleInside());
		//System.out.println(guard.check(" 9B 93 9A E5 OUT")); //empty
		System.out.println(guard.check(" 9B 93 9A E5 OUT")); //Ok
		System.out.println(guard.numberOfPeopleInside());

	}
}

	
