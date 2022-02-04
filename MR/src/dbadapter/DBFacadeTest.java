package dbadapter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import junit.framework.TestCase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;


public class DBFacadeTest extends TestCase{
	private MovieData movie;
	
	
	@Before
	public void setUp() {
		movie = new MovieData("titanic", "omar", "brad pitt", 2022);
		ArrayList<MovieData> MovieList= new ArrayList<MovieData>();
		MovieList.add(movie);
		
		String sqlCleanDB = "DROP TABLE IF EXISTS moviedatabase";
		String sqlCreateTableMD = "CREATE TABLE moviedatabase(title varchar(255), director varchar(255), mainactor varchar(255), publishdate int(15))";
		String sqlAddMovie = "INSERT INTO moviedatabase (title,director,mainactor,publishdate) VALUES (?,?,?,?)";
		
		String sqlCleanUserDB = "DROP TABLE IF EXISTS userdatabase";
		String sqlCreateTableUD = "CREATE TABLE userdatabase(name varchar(20), email varchar(200), age int)";
		String sqlregisteruser = "INSERT INTO userdatabase (name,email,age) VALUES (?,?,?)";
		 
		String sqlCleanReviewsDB = "DROP TABLE IF EXISTS reviews";
		String sqlCreateTableRD = "CREATE TABLE reviews(title varchar(20),name varchar(20), comment varchar(200), score int)";
		String sqlreview = "INSERT INTO reviews (title,name,comment,score) VALUES (?,?,?,?)";
		
		//String sqlgetmovies = "SELECT * FROM moviedatabase";
		
		try (Connection connection = DriverManager
				.getConnection(
						"jdbc:" + Configuration.getType() + "://" + Configuration.getServer() + ":"
								+ Configuration.getPort() + "/" + Configuration.getDatabase(),
						Configuration.getUser(), Configuration.getPassword())) {
			
			try(PreparedStatement psClean = connection.prepareStatement(sqlCleanDB))
			{
				psClean.executeUpdate();
			}
			
			try(PreparedStatement psCreateTableMD = connection.prepareStatement(sqlCreateTableMD))
			{
				psCreateTableMD.executeUpdate();
			}
			
			
			try (PreparedStatement ps = connection.prepareStatement(sqlAddMovie)) {
				
				ps.setString(1, movie.getTitle());
				ps.setString(2, movie.getDirector());
				ps.setString(3, movie.getMainactor());
				ps.setInt(4, movie.getPublishdate());
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			try (PreparedStatement psCleanUsers = connection.prepareStatement(sqlCleanUserDB)) {
                psCleanUsers.executeUpdate();
            }
			
			try(PreparedStatement psCreateTableUD = connection.prepareStatement(sqlCreateTableUD))
	            {
	                psCreateTableUD.executeUpdate();
	            }
			try (PreparedStatement psregisteruser = connection.prepareStatement(sqlregisteruser)) {
	                
	                psregisteruser.setString(1, "ali");
	                psregisteruser.setString(2, "omar");
	                psregisteruser.setInt(3, 20);
	                psregisteruser.executeUpdate();
	            }
			
			try (PreparedStatement psCleanReviews = connection.prepareStatement(sqlCleanReviewsDB)) {
                psCleanReviews.executeUpdate();
            }
			
			try(PreparedStatement psCreatTableR = connection.prepareStatement(sqlCreateTableRD))
            {
                psCreatTableR.executeUpdate();
            }
			
			try (PreparedStatement psratemovie = connection.prepareStatement(sqlreview)) {
                
                psratemovie.setString(1, "Titanic");
                psratemovie.setString(2, "ali");
                psratemovie.setString(3, "omar");
                psratemovie.setInt(4, 8);
                psratemovie.executeUpdate();
            }
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		

	@Test
	public void testshowMovieList()
	{
		ArrayList<MovieData> Movies = DBFacade.getInstance().showMovieList();
		assertTrue(Movies.size() == 1);
		assertEquals(Movies.get(0).getTitle(), movie.getTitle());
		assertEquals(Movies.get(0).getDirector(), movie.getDirector());
		assertEquals(Movies.get(0).getMainactor(), movie.getMainactor());
		assertEquals(Movies.get(0).getPublishdate(), movie.getPublishdate());
	}
	@Test
    public void testaddMovie() {

        assertTrue(DBFacade.getInstance().addMovie("Titanic", "Director", "Main Actor", 2000));

    }
	@Test
    public void testRegisterUser() {

        assertTrue(DBFacade.getInstance().RegisterUser("user name", "email@gmail.com", 20));

    }
	
	@Test
    public void testrateMovie() {

        assertTrue(DBFacade.getInstance().rateMovie("Titanic", "1", "nice movie", 7));

    }
	
	
	@After
	public void tearDown(){
		String sqlCleanDB = "DROP TABLE IF EXISTS moviedatabase, userdatabase, reviews";
		try (Connection connection = DriverManager
				.getConnection(
						"jdbc:" + Configuration.getType() + "://" + Configuration.getServer() + ":"
								+ Configuration.getPort() + "/" + Configuration.getDatabase(),
						Configuration.getUser(), Configuration.getPassword())) {
			
			try(PreparedStatement psClean = connection.prepareStatement(sqlCleanDB))
			{
				psClean.executeUpdate();
			}
		}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

