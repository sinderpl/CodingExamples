package FizzBuzz;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class fizzBuzzTest{
	//Amount of output numbers we want to check
	private int size = 5;
	//Instance of the FizzBuzz class
	FizzBuzz fizzBuzz = new FizzBuzz();
	
	
	/**
	 * 
	 * @throws Exception In case of issues with the output stream
	 * 
	 * 
	 */
	@Test
	public void testOutput() throws Exception{
		//Used to write the output to a byte array
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		//Sets the output of the class to the byteArray instead of 
		//the terminal window
		System.setOut(new PrintStream(output));
		
		//The output that we expect for the initial five numbers
		String expectedOutput = "1\n2\nFizz\n4\nBuzz\n";
		
		//Call on the class to perform the prinout methods
		fizzBuzz.printFizzBuzz(size);
		
		//Check whether the output is what we expected it to be
		assertEquals(expectedOutput, output.toString());
	}
}
