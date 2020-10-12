import java.io.File;
import java.util.*;

public class Checker {

    private String filename;
    private String delimiter;
    private boolean Checked = false;

    public Checker(String[] args) {
            try {
                
                if(args.length>2){
                    System.out.print("\nMore than required number of arguments !");
                    Help();
                    Warning();
                    System.exit(-1);
                }else if(args.length==1){
                    // String filePath = args[0];
                }
                else if(args[1].length() > 1) {
                    System.out.println("\nDelimiter must be a single character.");
                    System.out.print("Delimiter set by you - '"+args[1]+"'");
                    Help();
                    Warning();
                    System.exit(0);
                }

                String filePath = args[0];
                String extension = filePath.substring(filePath.lastIndexOf('.') + 1);

                List<String> extensions = Arrays.asList("doc","docx","odt","pdf","rtf","tex","txt","wpd");

                if(! extensions.contains(extension.toLowerCase())){
                    System.out.println("\nOnly text format is allowed. Your file-address have extension : '" + extension +"'");
                    System.exit(0);
                }

                File file = new File(filePath);

                // check if file exists
                if(!file.exists()) {
                    System.out.println("\nFile doesn't exist at file path : '" +filePath+"'");
                    System.exit(0);
                }

                // EMPTY File
                if(file.length()==0){
                    System.out.println("\nEmpty File !!! \t(please add non-empty file)");
                    System.exit(0);
                }
                
                
                try {
                    String content = "";

                    Scanner fileReader = new Scanner(file);
                    
                    while (fileReader.hasNextLine()) 
                        content += ("\n" + fileReader.nextLine());
                    
                    fileReader.close();

                    // ////// lang detection 
                    
                    textIsEnglish(content);
                }
                catch(Exception e) {
                    System.out.println(e);
                }

                
                


                //default delimiter is '.'
                String Delimiter = ".";
                if(args.length > 1) {
                    Delimiter = args[1];
                }

                //set the filename and Delimiter
                setChecked(true);
                setFilename(filePath);
                setDelimiter(Delimiter);
                
            } catch (Exception e) {
                System.out.println(e);
        }

        
    }

    public void Warning() {
        System.out.println("**Note : if file path contains space, Add '\\' before space OR Add complete file path in single quotes - '<FILE PATH>'");
    }

    public void Help() {
        System.out.println("\t(For more help, use '--help' tag)\n");
    }

    public void setFilename(String fileName) {
        this.filename = fileName;
    }

    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getFilename() {
        return this.filename;
    }

    public String getDelimiter() {
        return this.delimiter;
    }

    public boolean isChecked() {
        return Checked;
    }

    public void setChecked(boolean checked) {
        Checked = checked;
    }

    public static <T> Integer textIsEnglish(String text) {

        Map<String,Integer> lang = new HashMap<>();        


        for (char chars: text.toCharArray()) {
            lang.putIfAbsent(Character.UnicodeBlock.of(chars).toString(),1);
            lang.replace(Character.UnicodeBlock.of(chars).toString(),lang.get(Character.UnicodeBlock.of(chars).toString())+1);
        }
        
        Map<String,Integer> map = sortByValues(lang); 

        if(map.size()>1){
            System.out.println("\nWARNING : Text file is expected to be strictly in English. (Your text uses more than 1 languages) "+ "\nlanguages used in your text are : "+ map.keySet());
            System.out.println("**NOTE : English is composed of BASIC_LATIN**\n");
            // System.exit(0);
        }
        else if(! map.keySet().contains("BASIC_LATIN")){
            System.out.println("\nText file is not in English."+ "\nlanguage used in your text is : "+ map.keySet());
        }

        return 0;
    }

    private static HashMap sortByValues(Map<String, Integer> lang) {
        List list = new LinkedList(lang.entrySet());
        // Defined Custom Comparator here
        Collections.sort(list, new Comparator() {
             public int compare(Object o1, Object o2) {
                return -1*((Comparable) ((Map.Entry) (o1)).getValue())
                   .compareTo(((Map.Entry) (o2)).getValue());
             }
        });
 
        HashMap sortedHashMap = new LinkedHashMap();
        for (Iterator it = list.iterator(); it.hasNext();) {
               Map.Entry entry = (Map.Entry) it.next();
               sortedHashMap.put(entry.getKey(), entry.getValue());
        } 
        return sortedHashMap;
   }
}
