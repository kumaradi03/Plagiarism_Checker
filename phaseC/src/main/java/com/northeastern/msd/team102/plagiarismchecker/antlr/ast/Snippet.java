package com.northeastern.msd.team102.plagiarismchecker.antlr.ast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;


/**
 * @author mrunal
 * The class is responsible to generate
 * similar chunk of code among two different python programs.
 * reference for Longest Common subsequence : https://www.geeksforgeeks.org/print-longest-common-substring/
 *
 */
public class Snippet {

    public static final Logger logger = Logger.getLogger(Snippet.class.getName());
    /**
     *
     * @param pyLine String in python file.
     * @return count Integer returns Indentations count.
     */
    private int getIndentCount(String pyLine) {
        int count=0;
        char space=' ';
        int i=0;
        while((pyLine.charAt(i))==space) {
            count++;
            i++;
        }
        return count;
    }

    /**
     *
     * @param file python file
     * @return HashMap ProgramLines -> with key as intend count, and arrayList storing lines in a
     * 		 python program at that indentation.
     * @throws IOException
     */
    public Map<Integer, ArrayList<String>> fileToMap(File file) throws IOException {

        Map<Integer, ArrayList<String>> programLines = new HashMap<>();
        String pyLine;
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            logger.log(Level.INFO, e.getMessage());
            SendEmail.getInstance("End of line error (Exception caught in snippet.java) "
                    + "empty file has been submitted by student");
        }
        BufferedReader br = new BufferedReader(fileReader);
        try {
            while ((pyLine = br.readLine()) != null) {

                if ((pyLine.length()) != 0 && isComment(pyLine)) {
                    int intendCount = this.getIndentCount(pyLine);
                    if (programLines.containsKey(intendCount)) {
                        ArrayList<String> strings = programLines.get(intendCount);
                        strings.add(pyLine);
                        programLines.put(intendCount, strings);
                    } else {
                        ArrayList<String> strings = new ArrayList<>();
                        strings.add(pyLine);
                        programLines.put(intendCount, strings);
                    }

                }
            }
        } catch (IOException e) {
            logger.log(Level.INFO, e.getMessage());
            SendEmail.getInstance("End of line exception (Error in Snippet.java program), Please check if "
                    + "file is properly uploaded as per given format.");
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
     * @param file1Map Data structure of Hashmap of one python file
     * @param file2Map Data structure of Hashmap of another python file
     * @return Similar lines in two Python files.
     */
    public StringBuilder generateSimilarSnippet(Map<Integer, ArrayList<String>> file1Map, Map<Integer, ArrayList<String>> file2Map) {
        String currentString = "";
        StringBuilder strBuild=new StringBuilder();
        for (Map.Entry<Integer, ArrayList<String>> entry : file1Map.entrySet()) {
            int file1key = entry.getKey();
            ArrayList<String> file1Strings = entry.getValue();
            if (file2Map.containsKey(file1key)) {
                ArrayList<String> file2Strings = file2Map.get(file1key);
                for (String s1 : file1Strings) {
                    if (file2Strings.contains(s1)) {
                        currentString = s1;
                        logger.info(currentString);
                        strBuild = strBuild.append(currentString);


                    }
                }
            }
        }

        return strBuild;
    }

    /**
     *
     * @param x String
     * @param y String
     * @return Common substring within two strings.
     */
    @SuppressWarnings("unused")
    private String getLcs(String x, String y) {

        int xLength = x.length();
        int yLength = y.length();
        int[][] lcSuffix = new int[xLength + 1][yLength + 1];
        int commonLength = 0;
        int row = 0;
        int column = 0;
        StringBuilder substring=new StringBuilder();

        for (int i = 0; i < xLength; i++) {
            for (int j = 0; j < yLength; j++) {
                if (i == 0 || j == 0)
                    lcSuffix[i][j] = 0;
                else if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    lcSuffix[i][j] = lcSuffix[i - 1][j - 1] + 1;
                    if (commonLength < lcSuffix[i][j]) {
                        commonLength = lcSuffix[i][j];
                        row = i;
                        column = j;
                    }
                } else {
                    lcSuffix[i][j] = 0;
                }
            }
        }

        while (lcSuffix[row][column] != 0) {
            substring.append(x.charAt(row - 1));
            --commonLength;
            row--;
            column--;
        }
        return substring.toString();
    }
}