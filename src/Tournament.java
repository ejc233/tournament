import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Top-level class that accepts input and output as command-line arguments and
 * handles them appropriately.
 * 
 * @author echan
 */
public class Tournament {
	public static String inputFile;
	public static String outputFile;

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
				System.out.println(line);
			}

			inputReader.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}