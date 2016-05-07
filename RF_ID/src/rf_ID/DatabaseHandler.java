package rf_ID;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class DatabaseHandler {
	static final String CONNECTION_URL = "jdbc:postgresql:gate";
	static final String DRIVER_NAME = "org.postgresql.Driver";
	static final String USER = "test";
	static final String PASSWORD = "test";
	static final String PERSON_TABLE = "person";
	static final String PERSON_ID = "person_id";
	static final String PERSON_NAME = "name";
	static final String PERSON_PHOTO = "photo";
	static java.sql.Connection con = null;
	static Statement statement = null;
	
	public DatabaseHandler() {
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			con = DriverManager.getConnection(
				CONNECTION_URL, USER, PASSWORD);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			statement = con.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	//check if card has the right to be here
	boolean isRegistered(String card) {
		ResultSet rs = null;
		boolean result = false;
		try {
				rs = statement.executeQuery(
					"SELECT * FROM card WHERE card_id = '" + card +"';" );
				if (rs.next()) result = true;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return result;
	}
	ArrayList<RushHour> getRushHour() {
		ArrayList<RushHour> list = new ArrayList<>();
	//not implemented
		return list;
	}
	List<String> getListIn() {
		ArrayList<String> list = new ArrayList<>();
		HashSet<String> set = new HashSet<>();
		ResultSet rs = null;
		try {
				rs = statement.executeQuery(
					"SELECT * FROM entry ORDER BY entry_time DESC" );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while(rs.next()) {
	
			 //System.out.println(rs.getString("card_id"));
				String s = rs.getString("card_id");
			//System.out.println(rs.getString("direction"));
				String dir = rs.getString("direction");
				//System.out.println(dir);
				if(!set.contains(s)) {
					if(dir.equals("IN")) {
						list.add(s);
					}
					set.add(s); //mark as processed
				}
				else {
					//already processed entry
				}
			 //System.out.println(rs.getString("direction"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	void dumpResultSetColumn(ResultSet rs, String name) {
		try {
			while(rs.next()) {
	
					System.out.println(rs.getString(name));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void dumpResultSet(ResultSet rs) {
		try {
			while(rs.next()) {
				int col = rs.getMetaData().getColumnCount();
				for(int i = 1; i <= col; i ++) {
					System.out.print(rs.getString(i) + " ");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	String dumpResultSetToString(ResultSet rs) {
		StringBuilder sb = new StringBuilder();
		try {
			while(rs.next()) {
				int col = rs.getMetaData().getColumnCount();
				for(int i = 1; i <= col; i ++) {
					sb.append(rs.getString(i) + " ");
				}
				sb.append("\n");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb.toString();
	}
	void saveEntry(String card, String dir) {
	
		String querry = " INSERT INTO entry(card_id, direction) VALUES('" + card + "', '" + dir + "');";
		//System.out.println(querry);
		try {
				statement.executeQuery(querry);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	String getLog() {
		ResultSet rs = null;
		try {
			String querry = "SELECT * FROM entry";
			//System.out.println(querry);
			rs = statement.executeQuery(querry);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dumpResultSetToString(rs);
	}
	void clearLog() {
		
		try {
			String querry = "DELETE FROM entry";
			//System.out.println(querry);
			statement.executeQuery(querry);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	String getName(String card) {
		String result = null;
		ResultSet rs = null;
		try {
			String querry = "SELECT name FROM person JOIN card "
				+ "USING (person_id) WHERE card_id = '"
				+ card + "';";
			//System.out.println(querry);
			rs = statement.executeQuery(querry);
			if(rs.next()) result = rs.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	String getPersonId(String card) {
		String result = null;
		ResultSet rs = null;
		try {
			String querry = "SELECT person_id FROM person JOIN card "
				+ "USING (person_id) WHERE card_id = '"
				+ card + "';";
			//System.out.println(querry);
			rs = statement.executeQuery(querry);
			if(rs.next()) result = rs.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * Get person's image from PERSON_TABLE
	 * @param person_id
	 * @return 
	 */
	byte[] getPhoto(String person_id) {
		byte[] result = null;
		try {
		PreparedStatement ps = con.prepareStatement("SELECT " + PERSON_PHOTO + " FROM " +
		PERSON_TABLE + " WHERE " + PERSON_ID + " = ?");
		ps.setString(1, person_id);
		ResultSet rs = ps.executeQuery();
		if (rs != null) {
		    while (rs.next()) {
		       result = rs.getBytes(1);
		        // use the data in some way here
		    }
		    rs.close();
		}
		ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return result;
	}
	/** Set image of person to table PERSON_TABLE   
	 *
	 * @param person_id 
	 * @param pathToImage 
	 */
	
	void setPhoto (String person_id, String pathToImage) {
		
		URL imgURL = Access.class.getResource(pathToImage);
		File file = null;
		try {
			file = new File(imgURL.toURI());
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement ps = null;
		try{
			//update  person
			//set name = 'Donald Trump'
			//where person_id = '0000000002';
		String request = "UPDATE " + PERSON_TABLE + " SET " + PERSON_PHOTO + " = ? WHERE " + PERSON_ID + " = ?";
		//System.out.println(request);
		ps = con.prepareStatement(request);
		ps.setString(2, person_id);
		ps.setBinaryStream(1, fis, file.length());
		ps.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		try {
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DatabaseHandler base = new DatabaseHandler();
		//System.out.println(base.isRegistered("9B 93 9A E5"));
		System.out.println(base.getListIn());
	}
	
}
