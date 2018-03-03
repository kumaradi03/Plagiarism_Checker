package com.northeastern.msd.team102.plagiarismchecker.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.northeastern.msd.team102.plagiarismchecker.antlr.ast.ASTPrinter;
import com.northeastern.msd.team102.plagiarismchecker.antlr.ast.PythonParser;
import com.northeastern.msd.team102.plagiarismchecker.antlr.grammer.grammerParser.File_inputContext;

@RestController
@RequestMapping("/rest/file")
public class FileController {

	@GetMapping("/parse")
    public String parsePythonFile() throws IOException {
		PythonParser parserFacade = new PythonParser();
		File_inputContext ruleCtx = parserFacade.parse(new File("src/main/java/com/northeastern/msd/team102/plagiarismchecker/samplepython/SamplePythonFile1.py"));
        ASTPrinter astPrinter = new ASTPrinter(ruleCtx);
        return astPrinter.print();
	}
}
