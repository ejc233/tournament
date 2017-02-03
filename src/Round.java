import java.util.ArrayList;

/**
 * A single round in a tournament.
 * 
 * @author echan
 */
public class Round {
	private ArrayList<Competitor> inputList;
	private ArrayList<Competitor> winners = new ArrayList<Competitor>();
	private ArrayList<Competitor> losers = new ArrayList<Competitor>();
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

	public void runRound() {

		for (int i = 0; i < inputList.size() / 2; i++) {
			Competitor c1 = inputList.get(2 * i);
			Competitor c2 = inputList.get(2 * i + 1);

			double completeStrength = c1.getStrength() + c2.getStrength();
			double r = Math.random() * completeStrength;

			if (r <= c1.getStrength()) {
				winners.add(c1);
				losers.add(c2);

			} else {
				winners.add(c2);
				losers.add(c2);
			}
		}
	}

	/**
	 * Get the winners of the round.
	 * 
	 * @return the winners of the round
	 */
	public ArrayList<Competitor> getWinners() {
		return winners;
	}

	/**
	 * Get the losers of the round.
	 * 
	 * @return the losers of the round
	 */
	public ArrayList<Competitor> getLosers() {
		return losers;
	}
}