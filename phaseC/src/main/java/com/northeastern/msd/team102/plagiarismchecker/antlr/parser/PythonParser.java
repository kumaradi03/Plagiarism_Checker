package com.northeastern.msd.team102.plagiarismchecker.antlr.parser;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import com.northeastern.msd.team102.plagiarismchecker.antlr.grammer.grammerLexer;
import com.northeastern.msd.team102.plagiarismchecker.antlr.grammer.grammerParser;

/**
 * @version 1.0
 * @description reads a python file and calls the parser
 * @note this file is a reference from 'https://github.com/ftomassetti/python-ast'
 */
public class PythonParser {

	/**
	 * @param file : python file
	 * @param encoding : specifies the encoding type
	 * @return encoded string type of the input python file 
	 * @throws IOException
	 */
	private static String readFile(File file, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(file.toPath());
        return new String(encoded, encoding);
    }

	/**
	 * @param file : python file
	 * @return parsed python file of type 'RuleContext'
	 * @throws IOException
	 */
    public grammerParser.File_inputContext parse(File file) throws IOException {
        String code = readFile(file, Charset.forName("UTF-8"));
        grammerLexer lexer = new grammerLexer(new ANTLRInputStream(code));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        grammerParser parser = new grammerParser(tokens);
        return parser.file_input();
    }
}