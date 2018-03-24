package com.northeastern.msd.team102.plagiarismchecker.entity;

import org.junit.Test;
import org.mockito.internal.matchers.InstanceOf;

import static org.junit.Assert.*;

/**
 * Test suite for FileUpload entity
 */
public class FileUploadTest {
    @Test
    public void getHomework() throws Exception {
        byte[] testBytes=new byte[2];
        FileUpload testFileUpload = new FileUpload("testFileName",testBytes,"testMimeType");
        assertEquals(null,testFileUpload.getHomework());
    }

    @Test
    public void setHomework() throws Exception {
        byte[] testBytes=new byte[2];
        FileUpload testFileUpload = new FileUpload("testFileName",testBytes,"testMimeType");
        Homework testHomeWork = new Homework();
        testHomeWork.setName("homework1");
        testFileUpload.setHomework(testHomeWork);
        assertEquals("homework1",testFileUpload.getHomework().getName());
    }

    @Test
    public void getSetUser() throws Exception {
        byte[] testBytes=new byte[2];
        FileUpload testFileUpload = new FileUpload("testFileName",testBytes,"testMimeType");
        User testUser = new User();
        testUser.setUsername("testUserName");
        testFileUpload.setUser(testUser);
        assertEquals("testUserName",testFileUpload.getUser().getUsername());
    }

    @Test
    public void getSetId() throws Exception {
        byte[] testBytes=new byte[2];
        FileUpload testFileUpload = new FileUpload("testFileName",testBytes,"testMimeType");
        testFileUpload.setId(123);
        assertEquals(123,testFileUpload.getId());
    }

    @Test
    public void getFilename() throws Exception {
        byte[] testBytes=new byte[2];
        FileUpload testFileUpload = new FileUpload("testFileName",testBytes,"testMimeType");
        assertEquals("testFileName",testFileUpload.getFilename());
    }

    @Test
    public void setFilename() throws Exception {
        byte[] testBytes=new byte[2];
        FileUpload testFileUpload = new FileUpload("testFileName",testBytes,"testMimeType");
        testFileUpload.setFilename("testFileName2");
        assertEquals("testFileName2",testFileUpload.getFilename());
    }

    @Test
    public void getFile() throws Exception {
        byte[] testBytes=new byte[2];
        FileUpload testFileUpload = new FileUpload("testFileName",testBytes,"testMimeType");
        testFileUpload.setFilename("testFileName2");
        assertEquals(testBytes,testFileUpload.getFile());
    }

    @Test
    public void setFile() throws Exception {
        byte[] testBytes=new byte[2];
        FileUpload testFileUpload = new FileUpload("testFileName",testBytes,"testMimeType");
        byte[] testBytes2=new byte[2];
        testFileUpload.setFile(testBytes2);
        assertEquals(testBytes2,testFileUpload.getFile());

    }

    @Test
    public void getMimeType() throws Exception {
        byte[] testBytes=new byte[2];
        FileUpload testFileUpload = new FileUpload("testFileName",testBytes,"testMimeType");
        assertEquals("testMimeType",testFileUpload.getMimeType());
    }

    @Test
    public void setMimeType() throws Exception {
        byte[] testBytes=new byte[2];
        FileUpload testFileUpload = new FileUpload("testFileName",testBytes,"testMimeType");
        testFileUpload.setMimeType("testMimeType2");
        assertEquals("testMimeType2",testFileUpload.getMimeType());
    }

    @Test
    public void testDefaultConstructor() throws Exception {
        FileUpload testFileUpload = new FileUpload();
        testFileUpload.setMimeType("testMimeType2");
        assertEquals("testMimeType2",testFileUpload.getMimeType());
    }

}