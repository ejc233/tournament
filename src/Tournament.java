import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/**
 * Top-level class that accepts input and output as command-line arguments and
 * handles them appropriately.
 * 
 * @author echan
 */
public class Tournament {
	public static String inputFile;
	public static String outputFile;
	public static ArrayList<Competitor> competitors = new ArrayList<Competitor>();

	public static void main(String[] args) {
		inputFile = args[0];
		outputFile = args[1];
		try {
			BufferedReader inputReader = new BufferedReader(new FileReader(inputFile));

			String line = null;

			while ((line = inputReader.readLine()) != null) {
				String[] splitLine = line.split(" ");

				String name = splitLine[0];
				int strength = Integer.parseInt(splitLine[1]);

				Competitor competitor = new Competitor(name, strength);

				// create competitor, then add it so that it is in order of
				// strength
				competitors.add(competitor);
			}

			// priority queue for order?

			inputReader.close();

			if (competitors.size() % 2 != 0) {
				competitors.add(new Competitor("BYE", 0));
			}

			Round round = new Round(competitors, 1);
			ArrayList<Competitor> orderedList = round.runRound();

			// Write the ranked list into the output file
			writeFile(orderedList, outputFile);

		} catch (Exception e) {
			e.printStackTrace();
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
			writer.write(i + 1 + ". " + orderedList.get(i).getName());
			if (i != orderedList.size() - 1) {
				writer.newLine();
			}
		}

		writer.close();
	}

}