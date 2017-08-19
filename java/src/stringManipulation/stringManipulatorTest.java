package stringManipulation;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class stringManipulatorTest {
	
	/**
	 * https://github.com/junit-team/junit4/wiki/Parameterized-tests
	 * Tests based on this tutorial
	 */
	
	//Variable declarations
	final String testString = "I am currently interviewing at your company. ";
	private stringManipulator manipulator;
	private boolean expectedResult;
	private String string;
	
	//Set up the manipulator class
	@Before
	public void setup(){
		manipulator  = new stringManipulator();	
	}
	
	//Set up the parameters for the calss
	@Parameters
	public static Collection palindromeParams(){
		return Arrays.asList(new Object[][]{
			{true, ".radar."},
			{true, "radar"},
			{false, "cup"},
			{false, ".cup1."}
		});
	}
	
	/**
	 *  Assigns the two test values and tests the output
	 * @param expectedResult The boolean value expected to be returned by the method
	 * @param string The string to be tested in the isPalindrome method
	 */
	public stringManipulatorTest(boolean expectedResult, String string){
		this.expectedResult = expectedResult;
		this.string = string;
	}
	
	@Test
	public void testIsPalindrome() {
		assertEquals(expectedResult, manipulator.isPalindrome(string));
	}

}
