/**
 * Class for a single competitor in a tournament.
 * 
 * @author echan
 */
public class Competitor {
	private String name;
	private double strength;
	private int seed;

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
	 * Set the name of the competitor.
	 * 
	 * @param name
	 *            the new name of the competitor
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the strength of the competitor.
	 * 
	 * @return the strength of the competitor
	 */
	public double getStrength() {
		return strength;
	}

	/**
	 * Set the strength of the competitor.
	 * 
	 * @param strength
	 *            the new strength of the competitor
	 */
	public void setStrength(double strength) {
		this.strength = strength;
	}

	/**
	 * Get the seed of the competitor.
	 * 
	 * @return the seed of the competitor
	 */
	public int getSeed() {
		return seed;
	}

	/**
	 * Set the seed of the competitor.
	 * 
	 * @param seed
	 *            the new seed of the competitor
	 */
	public void setSeed(int sseed) {
		this.seed = seed;
	}

}