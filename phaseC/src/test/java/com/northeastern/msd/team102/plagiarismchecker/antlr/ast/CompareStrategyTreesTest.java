package com.northeastern.msd.team102.plagiarismchecker.antlr.ast;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;

import org.junit.Test;

/**
 * 
 *Comparison Strategy for Comparing two ASTs for python files.
 *
 */
public class CompareStrategyTreesTest {

	/**
	 * Comparison of samplepythonFile1.py and SamplePythonFile2.py.
	 * @throws IOException
	 */
	@Test
	public void test_compareAST1withAST2Boundary1() throws IOException, URISyntaxException {
		CompareStrategy c = new CompareStrategyTrees();
	    File file1=new File("src/main/java/com/northeastern/msd/team102/plagiarismchecker/samplepython/SamplePythonFile1.py");
		byte[] encodedFile1 = Files.readAllBytes(file1.toPath());
	    File file2=new File("src/main/java/com/northeastern/msd/team102/plagiarismchecker/samplepython/SamplePythonFile2.py");
		byte[] encodedFile2 = Files.readAllBytes(file2.toPath());		
	    assertEquals(94.12, c.compareFiles(encodedFile1, encodedFile2),2);
	}
	
	/**
	 * Comparison of samplepythonFile1.py and SamplePythonFile2.py.
	 * @throws IOException
	 */
	@Test
	public void test_compareAST1withAST2() throws IOException, URISyntaxException {
		CompareStrategy c = new CompareStrategyTrees();
		File file1 = new File("src/main/java/com/northeastern/msd/team102/plagiarismchecker/samplepython/SamplePythonFile1.py");
		byte[] encodedFile1 = Files.readAllBytes(file1.toPath());
	    File file2 = new File("src/main/java/com/northeastern/msd/team102/plagiarismchecker/samplepython/SamplePythonFile2.py");
		byte[] encodedFile2 = Files.readAllBytes(file2.toPath());

	    assertEquals(72.72, c.compareFiles(encodedFile2, encodedFile1),2);
	}
	
	/**
	 * Comparison of samplepythonFile1.py and calc.py.
	 * @throws IOException
	 */
	@Test
	public void test_compareAST1withAST2Boundary2() throws IOException, URISyntaxException {
		CompareStrategy c = new CompareStrategyTrees();
		File file1=new File("src/main/java/com/northeastern/msd/team102/plagiarismchecker/samplepython/SamplePythonFile1.py");
		byte[] encodedFile1 = Files.readAllBytes(file1.toPath());
	    File file2=new File("src/main/java/com/northeastern/msd/team102/plagiarismchecker/samplepython/calc.py");
		byte[] encodedFile2 = Files.readAllBytes(file2.toPath());
		
	    assertEquals(8.60, c.compareFiles(encodedFile2, encodedFile1),2);
	}
	
	/**
	 * Comparison of samplepythonFile1.py and empty file.
	 * @throws IOException
	 */
	@Test
	public void test_compareAST1withAST2BoundaryEmptyFile() throws IOException, URISyntaxException {
		CompareStrategy c = new CompareStrategyTrees();
		File file1=new File("src/main/java/com/northeastern/msd/team102/plagiarismchecker/samplepython/py21.py");
		byte[] encodedFile1 = Files.readAllBytes(file1.toPath());
	    File file2=new File("src/main/java/com/northeastern/msd/team102/plagiarismchecker/samplepython/calc.py");
		byte[] encodedFile2 = Files.readAllBytes(file2.toPath());
		
	   assertEquals(0, c.compareFiles(encodedFile2, encodedFile1),2);
	}
	
	/**
	 * Comparison of lists.py and lists2.py.
	 * @throws IOException
	 */
	@Test
	public void test_identifierRenaming() throws IOException, URISyntaxException {
		CompareStrategy c = new CompareStrategyTrees();
	    File file1=new File("src/main/java/com/northeastern/msd/team102/plagiarismchecker/samplepython/lists.py");
		byte[] encodedFile1 = Files.readAllBytes(file1.toPath());
	    File file2=new File("src/main/java/com/northeastern/msd/team102/plagiarismchecker/samplepython/lists2.py");
		byte[] encodedFile2 = Files.readAllBytes(file2.toPath());		
	    assertEquals(98.12, c.compareFiles(encodedFile1, encodedFile2),2);
	}
	
	/**
	 * Comparison of lists2.py and lists3.py.
	 * @throws IOException
	 */
	@Test
	public void test_codeRearranging() throws IOException, URISyntaxException {
		CompareStrategy c = new CompareStrategyTrees();
	    File file1=new File("src/main/java/com/northeastern/msd/team102/plagiarismchecker/samplepython/lists2.py");
		byte[] encodedFile1 = Files.readAllBytes(file1.toPath());
	    File file2=new File("src/main/java/com/northeastern/msd/team102/plagiarismchecker/samplepython/lists3.py");
		byte[] encodedFile2 = Files.readAllBytes(file2.toPath());		
	    assertEquals(98.12, c.compareFiles(encodedFile1, encodedFile2),2);
	}
	
	/**
	 * Comparison of lists2.py and lists3.py.
	 * @throws IOException
	 */
	@Test
	public void test_treeNodeCoverage() throws IOException, URISyntaxException {
		TreeNode t1 = new TreeNode("", "", 0);
		TreeNode t2 = new TreeNode("", "", 0);	    	
		TreeNode t3 = new TreeNode(null, null, 0);
		
	    assertEquals(true, t1.equals(t2));
	    assertEquals(false, t1.equals(t3));
	    assertEquals(0, t1.compareTo(t2));
	    assertEquals(-1, t1.compareTo(t3));
	    assertEquals(0, t2.compareTo(t1));
	    assertEquals(-1, t3.compareTo(t1));
	    assertEquals(-1, t3.compareTo(t2));
	}
	
}
