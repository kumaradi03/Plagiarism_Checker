package com.northeastern.msd.team102.plagiarismchecker.entity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test suite for File entity
 */
public class FileTest {
    @Test
    public void getHomework() throws Exception {
        byte[] testBytes=new byte[2];
        File testFile = new File("testFileName",testBytes,"testMimeType");
        assertEquals(null, testFile.getHomework());
    }

    @Test
    public void setHomework() throws Exception {
        byte[] testBytes=new byte[2];
        File testFile = new File("testFileName",testBytes,"testMimeType");
        Homework testHomeWork = new Homework();
        testHomeWork.setName("homework1");
        testFile.setHomework(testHomeWork);
        assertEquals("homework1", testFile.getHomework().getName());
    }

    @Test
    public void getSetUser() throws Exception {
        byte[] testBytes=new byte[2];
        File testFile = new File("testFileName",testBytes,"testMimeType");
        User testUser = new User();
        testUser.setUsername("testUserName");
        testFile.setUser(testUser);
        assertEquals("testUserName", testFile.getUser().getUsername());
    }

    @Test
    public void getSetId() throws Exception {
        byte[] testBytes=new byte[2];
        File testFile = new File("testFileName",testBytes,"testMimeType");
        testFile.setId(123);
        assertEquals(123, testFile.getId());
    }

    @Test
    public void getFilename() throws Exception {
        byte[] testBytes=new byte[2];
        File testFile = new File("testFileName",testBytes,"testMimeType");
        assertEquals("testFileName", testFile.getFilename());
    }

    @Test
    public void setFilename() throws Exception {
        byte[] testBytes=new byte[2];
        File testFile = new File("testFileName",testBytes,"testMimeType");
        testFile.setFilename("testFileName2");
        assertEquals("testFileName2", testFile.getFilename());
    }

    @Test
    public void getFile() throws Exception {
        byte[] testBytes=new byte[2];
        File testFile = new File("testFileName",testBytes,"testMimeType");
        testFile.setFilename("testFileName2");
        assertEquals(testBytes, testFile.getFile());
    }

    @Test
    public void setFile() throws Exception {
        byte[] testBytes=new byte[2];
        File testFile = new File("testFileName",testBytes,"testMimeType");
        byte[] testBytes2=new byte[2];
        testFile.setFile(testBytes2);
        assertEquals(testBytes2, testFile.getFile());

    }

    @Test
    public void getMimeType() throws Exception {
        byte[] testBytes=new byte[2];
        File testFile = new File("testFileName",testBytes,"testMimeType");
        assertEquals("testMimeType", testFile.getMimeType());
    }

    @Test
    public void setMimeType() throws Exception {
        byte[] testBytes=new byte[2];
        File testFile = new File("testFileName",testBytes,"testMimeType");
        testFile.setMimeType("testMimeType2");
        assertEquals("testMimeType2", testFile.getMimeType());
    }

    @Test
    public void testDefaultConstructor() throws Exception {
        File testFile = new File();
        testFile.setMimeType("testMimeType2");
        assertEquals("testMimeType2", testFile.getMimeType());
    }

}