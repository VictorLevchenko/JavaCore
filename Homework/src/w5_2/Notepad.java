package w5_2;

import java.text.*;
import java.util.*;

public class Notepad {
	private static final String DATE_FORMAT = "dd-MM-yyyy";
	private ArrayList<Note> notes = new ArrayList<>(); //collection of all notes in the notepad
	// note consist of date and text
	private class Note {		
		private Date date;
		private String text;
		//dateString should be in DATE_FORMAT
		private Note(String text, String dateString) throws ParseException {
			SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
			setDate(sdf.parse(dateString));
			setText(text);
		}
		//without explicit date will be current date
		private Note(String text) throws ParseException {
			this(text, (new SimpleDateFormat(DATE_FORMAT)).format(new Date()));
		}
		public String toString() {
			return (date + " ---> " + getText());
		}
		private Date getDate() {
			return date;
		}
		private void setDate(Date date) {
			this.date = date;
		}
		private String getText() {
			return text;
		}
		private void setText(String text) {
			this.text = text;
		}
	}
	
	private Collection<Note> getNotesByDate(String dateString) throws ParseException {
		Date theDate = (new SimpleDateFormat(DATE_FORMAT)).parse(dateString);
		ArrayList<Note> reportNotes = new ArrayList<>();
		for(Note e : notes) {
			if(e.getDate().equals(theDate))
				reportNotes.add(e);
		}
		return reportNotes;
	}
	private void addNote(Note note) {
		notes.add(note);
	}
	
	public void addNote(String text, String dateString) throws ParseException {
		this.addNote(new Note(text, dateString));
	}
	//add note with current date
	public void addNote(String text) throws ParseException {
		this.addNote(new Note(text));
	}
	//print all notes related to specified date 
	public void report(String dateString) throws ParseException {
		for(Note e: getNotesByDate(dateString)) {
			System.out.println(e);
		}
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Note e: notes) {
			sb.append(e);
			sb.append("\n");
		}
		return sb.toString();
	}
	
	
	public static void main(String[] args) throws ParseException {
		Notepad myNotepad = new Notepad();
		myNotepad.addNote("note number 1", "01-01-2016");
		myNotepad.addNote("note number 2", "01-01-2016");
		myNotepad.addNote("note number 3", "01-02-2017");
		myNotepad.addNote("note number 4");
		
		System.out.println(myNotepad);
		
		myNotepad.report("01-01-2016");

	}

}
