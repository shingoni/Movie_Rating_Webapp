package interfaces;


/**
 * Interface that provides all methods for the interaction with the Unregistered User.
 * 
 * @author swe.uni-due.de
 *
 */
public interface IUserDatabase {


	public boolean RegisterUser(String name, String email, int age);

}
