package servlets;
import org.junit.Before;
import org.junit.Test;

import net.sourceforge.jwebunit.junit.WebTester;

/**
 * This class performs a system test on the GuestGUI using JWebUnit.
 * 
 * @author swe.uni-due.de
 *
 */
public class UUGUITest {

	private WebTester tester;

	/**
	 * Create a new WebTester object that performs the test.
	 */
	@Before
	public void prepare() {
		tester = new WebTester();
		tester.setBaseUrl("http://localhost:8080/VR/");
	}

	@Test
	public void testRegisterUser() {
		// Start testing for uugui
		tester.beginAt("uugui");

		// Check all components of the search form
		tester.assertTitleEquals("Movie Rating App - register");
		tester.assertFormPresent();
		tester.assertTextPresent("Required Information");
		tester.assertTextPresent("name");
		tester.assertFormElementPresent("name");
		tester.assertTextPresent("email");
		tester.assertFormElementPresent("email");
		tester.assertTextPresent("age");
		tester.assertFormElementPresent("age");
		tester.assertButtonPresent("Register");

		// Submit the form with given parameters
		tester.setTextField("name", "Baz");
		tester.setTextField("email", "baz@gmail.com");
		tester.setTextField("age", "22");

		tester.clickButton("Register");
	
	}

}
