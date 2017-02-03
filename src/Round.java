import java.util.ArrayList;

/**
 * A single round in a tournament.
 * 
 * @author echan
 */
public class Round {
	private ArrayList<Competitor> inputList;
	private ArrayList<Competitor> outputList;
	private int roundNumber;

	/**
	 * Constructor.
	 * 
	 * @param inputList
	 *            the list of competitors coming into the round
	 * @param roundNumber
	 *            the round number
	 */
	public Round(ArrayList<Competitor> inputList, int roundNumber) {
		this.inputList = inputList;
		this.roundNumber = roundNumber;
	}
}