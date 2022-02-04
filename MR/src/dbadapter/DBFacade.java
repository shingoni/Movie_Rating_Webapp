package dbadapter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.IUserDatabase;
import interfaces.RUCmds;

/**
 * Class which acts as the connector between application and database. Creates
 * Java objects from SQL returns. Exceptions thrown in this class will be
 * catched with a 500 error page.
 *
 */
public class DBFacade implements IUserDatabase, RUCmds{
	private static DBFacade instance;

	/**
	 * Constructor which loads the corresponding driver for the chosen database type
	 */
	private DBFacade() {
		try {
			Class.forName("com." + Configuration.getType() + ".jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Implementation of the Singleton pattern.
	 * 
	 * @return
	 */
	public static DBFacade getInstance() {
		if (instance == null) {
			instance = new DBFacade();
		}

		return instance;
	}

	public static void setInstance(DBFacade dbfacade) {
		instance = dbfacade;
	}

	/**
	 * Register User Function
	 * 
	 * 
	 */
	public boolean RegisterUser(String name, String email, int age) {

		// Declare SQL query to register user into database.
		String sqlRegister = "INSERT INTO userdatabase (name,email,age) VALUES (?,?,?)";

		try (Connection connection = DriverManager
				.getConnection(
						"jdbc:" + Configuration.getType() + "://" + Configuration.getServer() + ":"
								+ Configuration.getPort() + "/" + Configuration.getDatabase(),
						Configuration.getUser(), Configuration.getPassword())) {

			try (PreparedStatement ps = connection.prepareStatement(sqlRegister)) {
				
				ps.setString(1, name);
				ps.setString(2, email);
				ps.setInt(3, age);
				ps.executeUpdate();
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}
	
	
	/**
	 * Add Movie Function
	 * 
	 * 
	 */
	public boolean addMovie(String title, String director, String mainactor,int publishdate) {

		// Declare SQL query to register user into database.
		String sqladd = "INSERT INTO moviedatabase (title,director,mainactor,publishdate) VALUES (?,?,?,?)";

		try (Connection connection = DriverManager
				.getConnection(
						"jdbc:" + Configuration.getType() + "://" + Configuration.getServer() + ":"
								+ Configuration.getPort() + "/" + Configuration.getDatabase(),
						Configuration.getUser(), Configuration.getPassword())) {

			try (PreparedStatement ps = connection.prepareStatement(sqladd)) {
				
				ps.setString(1, title);
				ps.setString(2, director);
				ps.setString(3, mainactor);
				ps.setInt(4, publishdate);
				ps.executeUpdate();
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}
	
	/**
	 * Show Movies Function
	 * 
	 * 
	 */
	
	public ArrayList<MovieData> showMovieList() {
		ArrayList<MovieData> result = new ArrayList<MovieData>();

		// Declare the necessary SQL queries.
		String sqlgetmovies = "SELECT * FROM moviedatabase";

		// Query all offers that fits to the given criteria.
		try (Connection connection = DriverManager
				.getConnection(
						"jdbc:" + Configuration.getType() + "://" + Configuration.getServer() + ":"
								+ Configuration.getPort() + "/" + Configuration.getDatabase(),
						Configuration.getUser(), Configuration.getPassword())) {

			try (PreparedStatement ps = connection.prepareStatement(sqlgetmovies)) {
				

				try (ResultSet rs = ps.executeQuery()) {
					while (rs.next()) {
						MovieData temp = new MovieData(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
						result.add(temp);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	
	/**
	 * Rate Movie Function
	 * 
	 * 
	 */
	public boolean rateMovie(String title, String name, String comment,int score) {

		// Declare SQL query to register user into database.
		String sqladd = "INSERT INTO reviews (title,name,comment,score) VALUES (?,?,?,?)";

		try (Connection connection = DriverManager
				.getConnection(
						"jdbc:" + Configuration.getType() + "://" + Configuration.getServer() + ":"
								+ Configuration.getPort() + "/" + Configuration.getDatabase(),
						Configuration.getUser(), Configuration.getPassword())) {

			try (PreparedStatement ps = connection.prepareStatement(sqladd)) {
				
				ps.setString(1, title);
				ps.setString(2, name);
				ps.setString(3, comment);
				ps.setInt(4, score);
				ps.executeUpdate();
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}
}
