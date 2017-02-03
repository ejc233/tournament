import java.util.ArrayList;

/**
 * A single round in a tournament.
 * 
 * @author echan
 */
public class Round {
	private ArrayList<Competitor> inputList;
	private ArrayList<Competitor> winnerList = new ArrayList<Competitor>();
	private ArrayList<Competitor> loserList = new ArrayList<Competitor>();
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

	public ArrayList<Competitor> runRound() {

		for (int i = 0; i < inputList.size() / 2; i++) {
			Competitor c1 = inputList.get(2 * i);
			Competitor c2 = inputList.get(2 * i + 1);

			double completeStrength = c1.getStrength() + c2.getStrength();
			double r = Math.random() * completeStrength;

			if (r <= c1.getStrength()) {
				winnerList.add(c1);
				loserList.add(c2);

			} else {
				winnerList.add(c2);
				loserList.add(c2);
			}
		}
		return winnerList;
	}
}