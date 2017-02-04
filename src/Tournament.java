import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Top-level class that accepts input and output as command-line arguments and
 * handles them appropriately.
 * 
 * @author echan
 */
public class Tournament {
	public static String inputFile;
	public static String outputFile;
	public static PriorityQueue<Competitor> seedQueue;
	public static ArrayList<Competitor> seedList;
	public static ArrayList<Competitor> competitorList;
	public static ArrayList<Competitor> rankedList;

	public static void main(String[] args) {
		inputFile = args[0];
		outputFile = args[1];

		Comparator<Competitor> comparator = new CompetitorComparator();
		seedQueue = new PriorityQueue<Competitor>(comparator);
		seedList = new ArrayList<Competitor>();
		competitorList = new ArrayList<Competitor>();
		rankedList = new ArrayList<Competitor>();

		try {
			BufferedReader inputReader = new BufferedReader(new FileReader(inputFile));

			String line = null;

			while ((line = inputReader.readLine()) != null) {
				String[] splitLine = line.split(" ");

				String name = splitLine[0];
				int strength = Integer.parseInt(splitLine[1]);

				Competitor competitor = new Competitor(name, strength);

				seedQueue.add(competitor);
			}

			inputReader.close();

			Competitor c;
			while ((c = seedQueue.poll()) != null) {
				seedList.add(c);
			}

			int exponent = 0;
			while (Math.pow(2, exponent) < seedList.size()) {
				exponent++;
			}

			while (seedList.size() < Math.pow(2, exponent)) {
				seedList.add(new Competitor("BYE", 0));
			}

			// at this point, the seed list is seeded correctly

			for (int i = 0; i < getMatches(exponent).length; i++) {
				competitorList.add(seedList.get((int) getMatches(exponent)[i] - 1));
			}

			int roundNumber = 1;
			Round round = new Round(competitorList, 1);
			round.runRound();
			ArrayList<Competitor> roundWinners = round.getWinners();
			ArrayList<Competitor> roundLosers = round.getLosers();
			for (Competitor loser : roundLosers) {
				if (!loser.getName().equals("BYE")) {
					rankedList.add(loser);
				}
			}

			while (roundWinners.size() > 1) {
				roundNumber++;
				round = new Round(roundWinners, roundNumber);
				round.runRound();
				roundWinners = round.getWinners();
				roundLosers = round.getLosers();
				for (Competitor loser : roundLosers) {
					if (!loser.getName().equals("BYE")) {
						rankedList.add(loser);
					}
				}
			}

			rankedList.addAll(roundWinners);

			// Write the ranked list into the output file
			writeFile(rankedList, outputFile);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static double[] getMatches(int exponent) {
		int N = exponent;
		double d = Math.pow(2, N);
		double d1 = d + 1;
		double[] data = new double[(int) d];
		data[0] = 1;
		data[1] = d;
		data[(int) d - 1] = d - 1;
		data[(int) d - 2] = 2;
		for (int i = 4; i < (int) d; i += 2) {
			data[i - 2] = f(N, i);
			data[i - 1] = d1 - data[i - 2];
		}
		return data;
	}

	public static double f(int N, int n) {
		double d = Math.pow(2, N) + 1;
		if (n == 2) {
			return d - 1;
		} else if (n % 2 == 1) {
			return d - f(N - 1, (n + 1) / 2);
		} else {
			return f(N - 1, n / 2);
		}
	}

	/**
	 * Write the ordered list to a file.
	 * 
	 * @param orderedList
	 *            the ordered list
	 * @param output
	 *            the output file path
	 * @throws IOException
	 */
	public static void writeFile(ArrayList<Competitor> orderedList, String output) throws IOException {
		File fout = new File(output);
		FileOutputStream fos = new FileOutputStream(fout);
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));

		// Write each string in the ranked list one by one
		for (int i = 0; i < orderedList.size(); i++) {
			writer.write(orderedList.get(orderedList.size() - i - 1).getName());
			if (i != orderedList.size() - 1) {
				writer.newLine();
			}
		}

		writer.close();
	}

}