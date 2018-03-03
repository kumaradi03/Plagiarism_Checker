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
public class CompareASTTest {


	/**
	 * Comparison of samplepythonFile1.py and SamplePythonFile2.py.
	 * @throws IOException
	 */
	@Test
	public void test_compareAST1withAST2Boundary1() throws IOException {
		PythonParser pyparser = new  PythonParser();
	    File file1=new File("src/main/java/com/northeastern/msd/team102/plagiarismchecker/samplepython/SamplePythonFile1.py");
	    File file2=new File("src/main/java/com/northeastern/msd/team102/plagiarismchecker/samplepython/SamplePythonFile2.py");
	    
	    grammerParser.File_inputContext f1=pyparser.parse(file1);
	    grammerParser.File_inputContext f2=pyparser.parse(file2);
	   
	    ASTPrinter astPrinter1 = new ASTPrinter(f1);
	    ASTPrinter astPrinter2= new ASTPrinter(f2);
	    astPrinter1.print();
	    astPrinter2.print();
	    
	    Map node1=astPrinter1.getNodes();
	    Map node2=astPrinter2.getNodes();
	    
	    CompareAST c=new CompareAST();
	   assertEquals(100.00, c.compareAST1withAST2(node1, node2),2);
	   
	    
	}
	
	/**
	 * Comparison of samplepythonFile1.py and SamplePythonFile2.py.
	 * @throws IOException
	 */
	@Test
	public void test_compareAST1withAST2() throws IOException {
		PythonParser pyparser = new  PythonParser();
	    File file1=new File("src/main/java/com/northeastern/msd/team102/plagiarismchecker/samplepython/SamplePythonFile1.py");
	    File file2=new File("src/main/java/com/northeastern/msd/team102/plagiarismchecker/samplepython/SamplePythonFile2.py");
	    
	    grammerParser.File_inputContext f1=pyparser.parse(file1);
	    grammerParser.File_inputContext f2=pyparser.parse(file2);
	   
	    ASTPrinter astPrinter1 = new ASTPrinter(f1);
	    ASTPrinter astPrinter2= new ASTPrinter(f2);
	    astPrinter1.print();
	    astPrinter2.print();
	    
	    Map node1=astPrinter1.getNodes();
	    Map node2=astPrinter2.getNodes();
	    
	    CompareAST c=new CompareAST();   
	    assertEquals(77.27, c.compareAST1withAST2(node2, node1),2); 	    
	}
	
	/**
	 * Comparison of samplepythonFile1.py and calc.py.
	 * @throws IOException
	 */
	@Test
	public void test_compareAST1withAST2Boundary2() throws IOException {
		PythonParser pyparser = new  PythonParser();
	    File file1=new File("src/main/java/com/northeastern/msd/team102/plagiarismchecker/samplepython/SamplePythonFile1.py");
	    File file2=new File("src/main/java/com/northeastern/msd/team102/plagiarismchecker/samplepython/calc.py");
	    
	    grammerParser.File_inputContext f1=pyparser.parse(file1);
	    grammerParser.File_inputContext f2=pyparser.parse(file2);
	   
	    ASTPrinter astPrinter1 = new ASTPrinter(f1);
	    ASTPrinter astPrinter2= new ASTPrinter(f2);
	    astPrinter1.print();
	    astPrinter2.print();
	    
	    Map node1=astPrinter1.getNodes();
	    Map node2=astPrinter2.getNodes();
	    
	    CompareAST c=new CompareAST();   
	    assertEquals(10.96, c.compareAST1withAST2(node2, node1),2); 	    
	}
	
}
