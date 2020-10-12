// import java.io.File;

public class ParseArguments {
    // private String filename;
    // private String delimiter;

    public ParseArguments(String[] args) {
        try {
            String arg = args[0];           // ArrayIndexOutOfBoundsException 
            if (arg.equals("--team")) {
                System.out.println();
                teamInfo();
                System.out.println();
                System.exit(0);
            } else if (arg.equals("--help")) {
                System.out.println();
                manual();
                System.out.println();
                System.exit(0);
            } 
            // else {

                // Checker check = new Checker(args);
                // check.isChecked();

                // String filePath = args[0];
                // File file = new File(filePath);

                // // check if file exists
                // if(!file.exists()) {
                //     System.out.println("file doesn't exists at file path : " + filePath);
                //     System.exit(0);
                // }

                // //default delimiter is '.'
                // String Delimiter = ".";
                // if(args.length > 1) {
                //     Delimiter = args[1];
                // }

                // //set the filename and Delimiter
                // setFilename(filePath);
                // setDelimiter(Delimiter);
            // }
        } catch (ArrayIndexOutOfBoundsException e) {
            //In case user doesn't provide any arguments to jar file
            System.out.println("\nPlease Enter arguments !\t(For more help, use '--help' tag)\n");
            System.exit(-1);
        }
    }

    // public void setFilename(String fileName) {
    //     this.filename = fileName;
    // }

    // public void setDelimiter(String delimiter) {
    //     this.delimiter = delimiter;
    // }

    // public String getFilename() {
    //     return this.filename;
    // }

    // public String getDelimiter() {
    //     return this.delimiter;
    // }

    private void teamInfo() {
        System.out.println("<< Team Info >>\n");
        System.out.println("Team Name : Software Fighters");
        System.out.println("\nMembers : ");
        System.out.println("\tManjeet Kapil (180010021) ");
        System.out.println("\tHarsh Raj (180010017) ");
        System.out.println("\tShriram Ghadge (180010015) ");
        System.out.println("\tRupesh Kalantre (180010029) ");
    }

    private void manual() {
        System.out.println("---------    MANUAL    ----------\n");
        String manual = "(This is a command-line program written in java to find no. of " +
            "lines, words, average length in your Essay/writting.)\n" +
            "\n\nHow-To guide : \n"  +
            "\n\t- To get the team Information : use '--team' flag with the jar file." +
            "\n\t> $ java -jar <PATH TO JAR FILE> --team\n" +
            "\n\t- To get the manual : use '--help' flag with the jar file" +
            "\n\t> $ java -jar <PATH TO JAR FILE> --help\n" +
        "\n\t- To use the jar file to find no. of average lines, words, total lines, execute following command:" +
            "\n\t> $ java -jar <PATH TO JAR FILE> <PATH TO YOUR ESSAY FILE> <DELIMITER IF ANY> <Minimum Word Length>\n" +
            "\n\t**Note : here delimiter means the character with which your sentence ends. " +
            "By default sentence ends with '.' character" +
            "\n\t- Default value of minimum word length is 4, this is optional argument";

        System.out.println(manual);
        System.out.println("\n--------- END OF MANUAL ----------");
    }
}
