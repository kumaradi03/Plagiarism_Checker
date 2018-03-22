package com.northeastern.msd.team102.plagiarismchecker.antlr.ast;




import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.LongStream;

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
	public Map<Integer, ArrayList<String>> fileToMap(File file) {
		
		Map<Integer, ArrayList<String>> ProgramLines = new HashMap<>();
		String pyLine;
		String comment = "'''";
		String oneLineComment = "#";

		FileReader fread = null;
		try {
			fread = new FileReader(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			SendEmail.email("End of line error (Exception cought in snippet.java) "
					+ "empty file has been submitted by student");
		}
		BufferedReader br = new BufferedReader(fread);

		try {
			while ((pyLine = br.readLine()) != null) {

				if ((pyLine.length()) != 0) {
					if (!((pyLine.startsWith(comment)) || (pyLine.startsWith(oneLineComment)))) {
						int intendCount = this.getIndentCount(pyLine);
						if (ProgramLines.containsKey(intendCount)) {
							ArrayList<String> strings = ProgramLines.get(intendCount);
							strings.add(pyLine);
							ProgramLines.put(intendCount, strings);
						} else {
							ArrayList<String> strings = new ArrayList<>();
							strings.add(pyLine);
							ProgramLines.put(intendCount, strings);
						}
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			SendEmail.email("End of line exception (Error in Snippet.java program), Please check if "
					+ "file is properly uploaded as per given format.");
		}
		return ProgramLines;	
	}
	
	/**
	 * @param File1Map Data structure of Hashmap of one python file
	 * @param File2Map Data structure of Hashmap of another python file
	 * @return Similar lines in two Python files.
	 */
	public StringBuilder generateSimilarSnippet(Map<Integer, ArrayList<String>> File1Map, Map<Integer, ArrayList<String>> File2Map) {
		String currentString = "";
		String longstring = "";
		StringBuilder StrBuild=new StringBuilder();
		for (Map.Entry<Integer, ArrayList<String>> entry : File1Map.entrySet()) {
			int file1key = entry.getKey();
			ArrayList<String> file1Strings = entry.getValue();

			if (File2Map.containsKey(file1key)) {
				ArrayList<String> file2Strings = File2Map.get(file1key);
				for (String s1 : file1Strings) {
					if (file2Strings.contains(s1)) {
						currentString = s1;
						StrBuild = StrBuild.append(currentString);
					}
				}
			}
		}
		System.out.println(StrBuild);
		return StrBuild;
	}
	
	/**
	 * 
	 * @param x String
	 * @param y String
	 * @return Common substring within two strings.
	 */
	private String getLCS(String x, String y) {

		int xLength = x.length();
		int yLength = y.length();
		int[][] lcSuffix = new int[xLength + 1][yLength + 1];
		int commonLength = 0, row = 0, column = 0;
		String substring = "";

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
		if (commonLength == 0)
			return substring;
		while (lcSuffix[row][column] != 0) {
			substring = x.charAt(row - 1) + substring;
			--commonLength;
			row--;
			column--;
		}
		return substring;
	}
}