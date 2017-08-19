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
	
	/**
	public AverageLetterTest(boolean expectedResult, String string){
		
	}**/
	
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
	
	
	public stringManipulatorTest(boolean expectedResult, String string){
		this.expectedResult = expectedResult;
		this.string = string;
	}

	@Test
	public void testAverageLetters() {
		assertEquals(expectedResult, manipulator.isPalindrome(string));
	}

}
