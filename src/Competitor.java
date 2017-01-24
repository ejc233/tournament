/**
 * Class for a single competitor in a tournament.
 * 
 * @author echan
 */
public class Competitor {
	private String name;
	private int strength;

	/**
	 * Constructor.
	 * 
	 * @param name
	 *            the name of the competitor
	 * @param strength
	 *            the strength of the competitor
	 */
	public Competitor(String name, int strength) {
		this.name = name;
		this.strength = strength;
	}

	/**
	 * Get the name of the competitor.
	 * 
	 * @return the name of the competitor
	 */
	public String getName() {
		return name;
	}

	/**
	 * Get the strength of the competitor.
	 * 
	 * @return the strength of the competitor
	 */
	public int getStrength() {
		return strength;
	}

	/**
	 * Set the name of the competitor.
	 * 
	 * @param name
	 *            the new name of the competitor
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Set the strength of the competitor.
	 * 
	 * @param strength
	 *            the new strength of the competitor
	 */
	public void setStrength(int strength) {
		this.strength = strength;
	}
}