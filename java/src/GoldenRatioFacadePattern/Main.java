package GoldenRatioFacadePattern;

/**
 * 
 * @author Alan Niemiec
 *
 *Main Class, creates and starts the Facade
 */
public class Main {

	//Static sequence size for the size of the sequences
	//As per the specification
	private static int sequenceSize = 25;
	public static void main(String[] args) {
		
		Facade facade = new Facade();
		//Starting the facade kicks off the calculations and printing
		facade.start(getSequenceSize());
	}
	public static int getSequenceSize() {
		return sequenceSize;
	}
	public static void setSequenceSize(int sequenceSize) {
		Main.sequenceSize = sequenceSize;
	}

}
