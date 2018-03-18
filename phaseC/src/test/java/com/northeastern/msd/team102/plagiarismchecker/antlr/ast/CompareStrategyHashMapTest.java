package com.northeastern.msd.team102.plagiarismchecker.antlr.ast;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.junit.Test;

import com.northeastern.msd.team102.plagiarismchecker.antlr.grammer.grammerParser;

/**
 * 
 *Comparison Strategy for Comparing two ASTs for python files.
 *
 */
public class CompareStrategyHashMapTest {

	/**
	 * Comparison of samplepythonFile1.py and SamplePythonFile2.py.
	 * @throws IOException
	 */
	@Test
	public void test_compareAST1withAST2Boundary1() throws IOException {
		CompareStrategyHashMap c = new CompareStrategyHashMap();
	    File file1=new File("src/main/java/com/northeastern/msd/team102/plagiarismchecker/samplepython/SamplePythonFile1.py");
	    File file2=new File("src/main/java/com/northeastern/msd/team102/plagiarismchecker/samplepython/SamplePythonFile2.py");
	    assertEquals(100.00, c.compareFiles(file1, file2),2);	    
	}
	
	/**
	 * Comparison of samplepythonFile1.py and SamplePythonFile2.py.
	 * @throws IOException
	 */
	@Test
	public void test_compareAST1withAST2() throws IOException {
		CompareStrategyHashMap c = new CompareStrategyHashMap();
		File file1=new File("src/main/java/com/northeastern/msd/team102/plagiarismchecker/samplepython/SamplePythonFile1.py");
	    File file2=new File("src/main/java/com/northeastern/msd/team102/plagiarismchecker/samplepython/SamplePythonFile2.py");
	    assertEquals(77.27, c.compareFiles(file2, file1),2); 	    
	}
	
	/**
	 * Comparison of samplepythonFile1.py and calc.py.
	 * @throws IOException
	 */
	@Test
	public void test_compareAST1withAST2Boundary2() throws IOException {
		CompareStrategyHashMap c = new CompareStrategyHashMap();
		File file1=new File("src/main/java/com/northeastern/msd/team102/plagiarismchecker/samplepython/SamplePythonFile1.py");
	    File file2=new File("src/main/java/com/northeastern/msd/team102/plagiarismchecker/samplepython/calc.py");
	    assertEquals(10.96, c.compareFiles(file2, file1),2);	    
	}
	
}
