package com.northeastern.msd.team102.plagiarismchecker.antlr.ast;


import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.junit.Test;

public class SnippeTests {

	/**
	 * Compares similar files.
	 * @throws IOException
	 */
	@Test
	public void test1() throws IOException {
		Snippet s=new Snippet();
		File file1 = new File("src/main/java/com/northeastern/msd/team102/plagiarismchecker/samplepython/SamplePythonFile1.py");
		File file2 = new File("src/main/java/com/northeastern/msd/team102/plagiarismchecker/samplepython/SamplePythonFile2.py");		
		Map<Integer, ArrayList<String>> File1Map=s.fileToMap(file1);
		Map<Integer, ArrayList<String>> File2Map=s.fileToMap(file2);		
		String currentString=(s.generateSimilarSnippet(File1Map, File2Map)).toString();
		String expected="def main():"
				+ "if __name__ == \"__main__\": main()";
		assertEquals(expected, currentString);
	}
	
	/**
	 * Compares totally different files.
	 * @throws IOException
	 */
	@Test
	public void test2() throws IOException {
		Snippet s=new Snippet();
		File file1 = new File("src/main/java/com/northeastern/msd/team102/plagiarismchecker/samplepython/SamplePythonFile1.py");
		File file2 = new File("src/main/java/com/northeastern/msd/team102/plagiarismchecker/samplepython/calc.py");		
		Map<Integer, ArrayList<String>> File1Map=s.fileToMap(file1);
		Map<Integer, ArrayList<String>> File2Map=s.fileToMap(file2);		
		String currentString=s.generateSimilarSnippet(File1Map, File2Map).toString();
		assertEquals("",currentString);
	}
	
	/**
	 * Compares two similar files.
	 * @throws IOException
	 */
	@Test
	public void test3() throws IOException {
		Snippet s=new Snippet();
		File file1 = new File("src/main/java/com/northeastern/msd/team102/plagiarismchecker/samplepython/beautifulSoup.py");
		File file2 = new File("src/main/java/com/northeastern/msd/team102/plagiarismchecker/samplepython/bs4-file.py");		
		Map<Integer, ArrayList<String>> File1Map=s.fileToMap(file1);
		Map<Integer, ArrayList<String>> File2Map=s.fileToMap(file2);		
		String currentString=s.generateSimilarSnippet(File1Map, File2Map).toString();
		String expected="import requestsurl = \"https://en.wikipedia.org/wiki/Tropical_cyclone\"code = requests.get(url)text = code.text        fob.write(href + '\\n')";
		assertEquals(expected, currentString);
	}
}
