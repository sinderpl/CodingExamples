package GoldenRatioFacadePattern;

import java.util.ArrayList;


public interface INumberSequence{
	public void calculate(int size);
	public int calculateRecursively(int size);
	public ArrayList<Integer> getSequence();
}
