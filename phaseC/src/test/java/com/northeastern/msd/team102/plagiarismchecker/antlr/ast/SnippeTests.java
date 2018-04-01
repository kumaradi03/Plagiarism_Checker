package com.northeastern.msd.team102.plagiarismchecker.antlr.ast;


import static org.junit.Assert.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class SnippeTests {

	/**
	 * Compares similar files.
	 * @throws IOException
	 */
	@Test
	public void test1() throws IOException {
		Snippet s = new Snippet();
		File file1 = new File("src/main/java/com/northeastern/msd/team102/plagiarismchecker/samplepython/SamplePythonFile1.py");
		File file2 = new File("src/main/java/com/northeastern/msd/team102/plagiarismchecker/samplepython/SamplePythonFile2.py");
		ArrayList<String> File1Lines = s.fileToList(file1);
		ArrayList<String> File2Lines = s.fileToList(file2);
		int[] similarLines  = s.findSimilarLines(File1Lines, File2Lines);
		int[] expectedLines = {1, -1, 4};
		assertArrayEquals(expectedLines, similarLines);	
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
		ArrayList<String> File1Lines = s.fileToList(file1);
		ArrayList<String> File2Lines = s.fileToList(file2);
		int[] similarLines  = s.findSimilarLines(File1Lines, File2Lines);
		int[] expectedLines = {-1, -1, -1};
		assertArrayEquals(expectedLines, similarLines);	
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
		ArrayList<String> File1Lines = s.fileToList(file1);
		ArrayList<String> File2Lines = s.fileToList(file2);
		int[] similarLines  = s.findSimilarLines(File1Lines, File2Lines);
		int[] expectedLines = {1, 2, 3, 4, -1, -1, -1, -1, 9};
		assertArrayEquals(expectedLines, similarLines);	
	}
	
	/**
	 * Compares empty file.
	 * @throws IOException
	 */
	@Test
	public void test4() throws IOException {
		Snippet s=new Snippet();
		File file1 = new File("src/main/java/com/northeastern/msd/team102/plagiarismchecker/samplepython/empty.py");
		File file2 = new File("src/main/java/com/northeastern/msd/team102/plagiarismchecker/samplepython/bs4-file.py");
		ArrayList<String> File1Lines = s.fileToList(file1);
		ArrayList<String> File2Lines = s.fileToList(file2);
		int[] similarLines  = s.findSimilarLines(File1Lines, File2Lines);
		int[] expectedLines = {};
		assertArrayEquals(expectedLines, similarLines);	
	}
}
