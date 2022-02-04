package interfaces;

import java.util.ArrayList;

import dbadapter.MovieData;

/**
 * Interface that provides all methods for the interaction with the Registered User.
 * 
 * @author swe.uni-due.de
 *
 */
public interface RUCmds {

	public boolean addMovie(String title, String director, String mainactor,int publishdate);
	
	public boolean rateMovie(String title,String name,String comment, int score);
	
	public ArrayList<MovieData> showMovieList();
	

}
