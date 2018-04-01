import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 * @author mrunal
 * The class is responsible to generate
 * similar chunk of code among two different python programs.
 * reference for Longest Common subsequence : https://www.geeksforgeeks.org/print-longest-common-substring/
 *
 */
public class Snippet {

    /**
     *
     * @param file python file
     * @return ArrayList ProgramLines -> array of lines in the python file. 
     * @throws IOException
     */
    public  ArrayList<String> fileToList(File file) throws IOException {

        ArrayList<String>programLines = new ArrayList();
        String pyLine;
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
        	e.getMessage();
        }
        BufferedReader br = new BufferedReader(fileReader);
        try {
            while ((pyLine = br.readLine()) != null) {
            	if ((pyLine.length()) != 0 && isComment(pyLine)) {
            		programLines.add(pyLine);
            	}
                }
            } catch (IOException e) {
          e.getMessage();         
        } finally {
            br.close();
        }
        return programLines;
    }

    /**
     *
     * @param pyLine String to check.
     * @return true if String passed in not a comment.
     */   
    private Boolean isComment(String pyLine) {
        String comment = "'''";
        String oneLineComment = "#";
        return (!((pyLine.startsWith(comment)) || (pyLine.startsWith(oneLineComment))));

    }
    /**
     * 
     * @param file1Strings List of lines in given python file.
     * @param file2Strings List of lines in supspected python file.
     * @return
     */
    public int[] findSimilarLines(List<String> file1Strings, List<String> file2Strings) {
    	lcs l=new lcs();
    	Double count= 0.0;    	
    	int k=0; 	
    	if(file1Strings == null || file2Strings == null)
    		return null;
    	int similarLines[] = new int[file1Strings.size()];
    	for(String file1Line : file1Strings) {
    		int maxSimilarLength = 0;
    		int lineNo = 1;
    		similarLines[k] = -1;
    		for (String file2Line : file2Strings) {
    			String snippet =l.printLCSubStr(file1Line, file2Line);
    			if(snippet.length() > maxSimilarLength && snippet.length() >= file1Line.length() * 0.75 && snippet.length() >= file1Line.length() * 0.75) {
    				similarLines[k] = lineNo;
    				maxSimilarLength=snippet.length();
    			}
    			lineNo++;
    		}   		
    		if(similarLines[k] != -1) {
    			count++;
    		}	
    		k++;	
    	}    	
    	//double score = (count/(double) file1Strings.size()) * 100;   	
    	return similarLines;   	
    }
    
   
    public static void main(String[] args) throws IOException {
    	Snippet s=new Snippet();
    	File file1 = new File("C:\\Python\\python_programs\\beautifulSoup.py");
		File file2 = new File("C:\\Python\\python_programs\\bs4-file.py");			
	   ArrayList<String> File1Lines=s.fileToList(file1);
	   ArrayList<String> File2Lines=s.fileToList(file2);		
	  int[] currentString=(s.findSimilarLines(File1Lines, File2Lines));
	  for(int i=0;i <= currentString.length-1;i++)
		System.out.println(currentString[i]);

    }
}