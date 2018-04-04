package com.northeastern.msd.team102.plagiarismchecker.antlr.ast;


import static org.junit.Assert.*;
import java.io.File;
import java.io.IOException;
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
		String[] detailedReport=s.generateSnippets(file1, file2);
		String file1Report="<div><p style=\"white-space :pre-wrap ;color :red\">"
				+ "1def main():<br>"
				+ "2    print (\"Hello World!\")<br>"
				+ "3if __name__ == \"__main__\": main()<br></p></div>";
		String file2Report= "<div><p style=\"white-space :pre-wrap ;color :red\">"
				+ "1def main():<br>"
				+ "2    print (\"Hello \")<br>"
				+ "4if __name__ == \"__main__\": main()<br></p></div>";
		assertEquals(file1Report, detailedReport[0]);
		assertEquals(file2Report, detailedReport[1]);
	}
	
	
}
