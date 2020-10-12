import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		ParseArguments parser = new ParseArguments(args);
		Checker check = new Checker(args);
		if(check.isChecked()){
			// System.out.println("checked !!");
			System.out.println("SUMMERY : ");
			Summary sm = new Summary(check.getFilename(), check.getDelimiter(), check.getMinWordLength());
			System.out.println("File used for processing : " + check.getFilename());
			System.out.println("Delimiter used to separate sentences in text : " + "'" + check.getDelimiter() + "'");
			System.out.println("Minimum word Length used to calculate word count in text : " + check.getMinWordLength());
//			System.out.println(sm.getSummary());
			System.out.println();
			System.out.printf("Number of words in your text                 : %d\n", sm.getWordCount());
			System.out.printf("Number of sentences in your text             : %d\n", sm.getSentenceCount());
			System.out.printf("Average length of each sentence in your text : %d\n", sm.getAvgLength());
		}
		
	}
}
