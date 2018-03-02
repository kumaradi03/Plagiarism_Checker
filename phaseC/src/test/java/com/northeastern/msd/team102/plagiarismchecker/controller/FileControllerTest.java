package com.northeastern.msd.team102.plagiarismchecker.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@RunWith(SpringRunner.class)
@WebMvcTest(value = FileController.class, secure = false)
public class FileControllerTest {

	@Autowired
    private MockMvc mockMvc;
	
	@MockBean
    private FileController fileController;
	
    @Test
    public void parse() throws Exception {
    	FileController f = new FileController();
    	String mockParsedFile = "ruleName = file_input\r\n" + 
        		"  funcdef\r\n" + 
        		"    parameters\r\n" + 
        		"    suite\r\n" + 
        		"      simple_stmt\r\n" + 
        		"        atom_expr\r\n" + 
        		"          atom\r\n" + 
        		"          trailer\r\n" + 
        		"            atom\r\n" + 
        		"  if_stmt\r\n" + 
        		"    comparison\r\n" + 
        		"      atom\r\n" + 
        		"      comp_op\r\n" + 
        		"      atom\r\n" + 
        		"    atom_expr\r\n" + 
        		"      atom\r\n" + 
        		"      trailer\r\n" + 
        		"file_input\r\n";
    	
    	Mockito.when(fileController.parsePythonFile()).thenReturn(mockParsedFile);
    	RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/rest/file/parse").accept(MediaType.APPLICATION_JSON);
    	
    	MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        assertEquals(mockParsedFile, result.getResponse().getContentAsString());
    }
}