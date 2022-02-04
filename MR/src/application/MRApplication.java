package application;

import java.util.ArrayList;

import dbadapter.DBFacade;
import dbadapter.MovieData;
import interfaces.RUCmds;
import interfaces.IUserDatabase;

/**
 * This class contains the MRApplication which acts as the interface between all
 * components.
 * 
 * @author swe.uni-due.de
 *
 */
public class MRApplication implements RUCmds, IUserDatabase {

	private static MRApplication instance;

	/**
	 * Implementation of the Singleton pattern.
	 * 
	 * @return
	 */
	public static MRApplication getInstance() {
		if (instance == null) {
			instance = new MRApplication();
		}

		return instance;
	}

	
	public boolean RegisterUser(String name, String email, int age) {

		try {
			DBFacade.getInstance().RegisterUser(name, email, age);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	
	public boolean addMovie(String title, String director, String mainActor, int publishdate) {

		try {
			DBFacade.getInstance().addMovie(title, director, mainActor, publishdate);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	public ArrayList<MovieData> showMovieList() {
		ArrayList<MovieData> result = null;
		try {
			result = DBFacade.getInstance().showMovieList();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return result;
	}
	
	
	public boolean rateMovie(String title, String name, String comment, int score) {

		try {
			DBFacade.getInstance().rateMovie(title, name, comment, score);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
