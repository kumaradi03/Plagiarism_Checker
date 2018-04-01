package com.northeastern.msd.team102.plagiarismchecker.antlr.ast;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



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
        	SendEmail.getInstance("Exception caught in Snippet.java."
					+ "empty file submitted");
        }
        BufferedReader br = new BufferedReader(fileReader);
        try {
            while ((pyLine = br.readLine()) != null) {
            	if ((pyLine.length()) != 0 && isComment(pyLine)) {
            		programLines.add(pyLine);
            	}
                }
            } catch (IOException e) {
            	SendEmail.getInstance("Exception caught in Snippet.java."
    					+ "empty file submitted");
        } finally {
            br.close();
        }
        return programLines;
    }

    /**
     *
     * @param pyLine String to check.
     * @return true if String passed is not a comment.
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
    	Double count= 0.0;    	
    	int k=0; 
    	LCS lcs=new LCS();
    	if(file1Strings == null || file2Strings == null)
    		return null;
    	int similarLines[] = new int[file1Strings.size()];
    	for(String file1Line : file1Strings) {
    		int maxSimilarLength = 0;
    		int lineNo = 1;
    		similarLines[k] = -1;
    		for (String file2Line : file2Strings) {
    			String snippet =lcs.LcsSubString(file1Line, file2Line);
    			if(snippet.length() > maxSimilarLength && (snippet.length() >= file1Line.length() * 0.75) && (snippet.length() >= file2Line.length() * 0.75)) {
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
    	return similarLines;   	
    }
}