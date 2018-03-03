package com.northeastern.msd.team102.plagiarismchecker.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import com.northeastern.msd.team102.plagiarismchecker.entity.FileUpload;
import com.northeastern.msd.team102.plagiarismchecker.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.northeastern.msd.team102.plagiarismchecker.antlr.ast.ASTPrinter;
import com.northeastern.msd.team102.plagiarismchecker.antlr.ast.PythonParser;
import com.northeastern.msd.team102.plagiarismchecker.antlr.grammer.grammerParser.File_inputContext;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


@RestController
@RequestMapping("/rest/file")
public class FileController {

    @Autowired
    FileUploadService fileUploadService;

    @GetMapping("/parse")
    public String parsePythonFile() throws IOException {
		PythonParser parserFacade = new PythonParser();
		File_inputContext ruleCtx = parserFacade.parse(new File("src/main/java/com/northeastern/msd/team102/plagiarismchecker/samplepython/SamplePythonFile1.py"));
        ASTPrinter astPrinter = new ASTPrinter(ruleCtx);
        return astPrinter.print();
	}

    @PostMapping("/upload")
    public void uploadFile(MultipartHttpServletRequest request) throws IOException {
        Iterator<String> itr = request.getFileNames();
        while (itr.hasNext()) {
            String uploadedFile = itr.next();
            MultipartFile file = request.getFile(uploadedFile);
            String mimeType = file.getContentType();
            String filename = file.getOriginalFilename();
            byte[] bytes = file.getBytes();
            FileUpload newFile = new FileUpload(filename, bytes, mimeType);
            fileUploadService.uploadFile(newFile);
        }
    }
}
