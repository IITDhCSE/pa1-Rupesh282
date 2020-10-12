import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Summary {
	private String filepath;
	private String delimiter;
	private int wordLengthTH;

	private Map<String, String> converter = new HashMap<String, String>(){{
			put(".", "\\.");
		}};

	public Summary(String filepath, String delimiter, int wordLengthTH) {
		this.filepath = filepath;
		this.delimiter = converter.getOrDefault(delimiter, delimiter);
		this.wordLengthTH = wordLengthTH;
	}

	private int countWords(String contents) {
		String[] words = contents.trim().split(" ");
		//to count the number of words according the minimum decided length of the word
		//i.e if word has minimum length wordLengthTH , it will be counted.
		int wordCount = 0;
		for(String i : words)
			wordCount += (i.length() >= wordLengthTH ? 1 : 0);
		return wordCount;
	}

	private int countSentences(String contents) {
		String[] sentences = contents.trim().split(delimiter);
		return ((sentences[0] != "" || sentences.length > 1) ? sentences.length: 0);
	}

	private String getFileContents() {
		String contents = "";

		// Read all contents from file
		try {
			File file = new File(filepath);
			Scanner fileReader = new Scanner(file);
			
			while (fileReader.hasNextLine()) 
				contents += ("\n" + fileReader.nextLine());
			
			fileReader.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("File not found " + filepath);
		}

		return contents;
	}

	public Map<Description, Integer> getSummary() {
		HashMap<Description, Integer> summary = new HashMap<Description, Integer>();
		String contents = getFileContents().replace('\n', ' ').trim();

		// System.out.println(contents + Arrays.toString(contents.trim().split(" ")));

		// calculate the statistics of the contents of file
		int numSentences = countSentences(contents);
		int numWords = countWords(contents);
		int averageLength = (numSentences > 0 ? numWords/ numSentences : 0);

		// prepare summary
		summary.put(Description.numWords, numWords);
		summary.put(Description.numSentences, numSentences);
		summary.put(Description.averageLength, averageLength);

		return summary;
	}
}
