package com.northeastern.msd.team102.plagiarismchecker.antlr.ast;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;

import static org.junit.Assert.assertEquals;

/**
 *
 *Comparison Strategy for Comparing two ASTs for python files.
 *
 */
public class CompareStrategyLevenshteinDistTest {

	/**
	 * Comparison of samplepythonFile1.py and SamplePythonFile2.py.
	 * @throws IOException
	 */
	@Test
	public void test_compareAST1withAST2Boundary1() throws IOException, URISyntaxException {
		CompareStrategy c = new CompareStrategyLevenshteinDist();
		File file1=new File("src/main/java/com/northeastern/msd/team102/plagiarismchecker/samplepython/SamplePythonFile1.py");
		byte[] encodedFile1 = Files.readAllBytes(file1.toPath());
		File file2=new File("src/main/java/com/northeastern/msd/team102/plagiarismchecker/samplepython/SamplePythonFile2.py");
		byte[] encodedFile2 = Files.readAllBytes(file2.toPath());
		assertEquals(83.00, c.compareFiles(encodedFile1, encodedFile2),2);
	}

	/**
	 * Comparison of samplepythonFile1.py and SamplePythonFile1.py.
	 * @throws IOException
	 */
	@Test
	public void test_compareAST1withAST2Boundary2() throws IOException, URISyntaxException {
		CompareStrategy c = new CompareStrategyLevenshteinDist();
		File file1=new File("src/main/java/com/northeastern/msd/team102/plagiarismchecker/samplepython/SamplePythonFile1.py");
		byte[] encodedFile1 = Files.readAllBytes(file1.toPath());
		File file2=new File("src/main/java/com/northeastern/msd/team102/plagiarismchecker/samplepython/SamplePythonFile1.py");
		byte[] encodedFile2 = Files.readAllBytes(file2.toPath());
		assertEquals(100.00, c.compareFiles(encodedFile1, encodedFile2),2);
	}


	/**
	 * Comparison of samplepythonFile1.py and SamplePythonFile2.py.
	 * @throws IOException
	 */
	@Test
	public void test_compareAST1withAST2() throws IOException, URISyntaxException {
		CompareStrategy c = new CompareStrategyLevenshteinDist();
		File file1 = new File("src/main/java/com/northeastern/msd/team102/plagiarismchecker/samplepython/SamplePythonFile1.py");
		byte[] encodedFile1 = Files.readAllBytes(file1.toPath());
		File file2 = new File("src/main/java/com/northeastern/msd/team102/plagiarismchecker/samplepython/SamplePythonFile2.py");
		byte[] encodedFile2 = Files.readAllBytes(file2.toPath());
		assertEquals(83.00, c.compareFiles(encodedFile2, encodedFile1),2);
	}

	/**
	 * Comparison of samplepythonFile1.py and calc.py.
	 * @throws IOException
	 */
	@Test
	public void test_compareAST1withAST2Boundary3() throws IOException, URISyntaxException {
		CompareStrategy c = new CompareStrategyLevenshteinDist();
		File file1=new File("src/main/java/com/northeastern/msd/team102/plagiarismchecker/samplepython/SamplePythonFile1.py");
		byte[] encodedFile1 = Files.readAllBytes(file1.toPath());
		File file2=new File("src/main/java/com/northeastern/msd/team102/plagiarismchecker/samplepython/calc.py");
		byte[] encodedFile2 = Files.readAllBytes(file2.toPath());
		assertEquals(0.0, c.compareFiles(encodedFile2, encodedFile1),2);
	}

}
