package GoldenRatioFacadePattern;

/**
 * 
 * @author Alan Niemiec
 *
 * Facade pattern allowing for the calculation of numerical sequences based on Fibonacci, Lucas and Golden Ratio,
 * mathematical proofs
 */
public class Facade {
	//Sequence Generators
	private Lucas lucas = new Lucas();
	private Fibonacci fibonacci = new Fibonacci();
	private GoldenRatio goldenRatio = new GoldenRatio();
	

	/**
	 * Method used for calculating the sequences
	 */
	public void start(int sequenceSize){
		//Calculate the fibonacci sequence
		fibonacci.calculate(sequenceSize);
		
		//Calculate the Lucas sequence
		lucas.calculate(sequenceSize);
		
		//Calculate the Golden Ratio sequence
		goldenRatio.calculate(sequenceSize);
		
		//Print the output of the sequences
		printSequence(sequenceSize);
		
	}
	
	/**
	 * Prints the output of the Lucas, Fibonacci and Golden Ratio sequences
	 */
	
	private void printSequence(int sequenceSize){
		System.out.println("Proofing that the Lucas numbers come closer to the Golden Ratio than the Fibonacci numbers:");
		System.out.println("Fibonacci		"+"Lucas		"+"Phi rounded");
		
		for(int x=0; x<=sequenceSize-1; x++){
			System.out.println(fibonacci.getSequence().get(x)+"			"+lucas.getSequence().get(x)+"		" + goldenRatio.getSequence().get(x));
		}
		
	}
	
	
}
