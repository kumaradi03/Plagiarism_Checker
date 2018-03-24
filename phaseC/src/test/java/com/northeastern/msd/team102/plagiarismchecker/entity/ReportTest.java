package com.northeastern.msd.team102.plagiarismchecker.entity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test suite for Report entity
 */
public class ReportTest {


    @Test
    public void getSetId() throws Exception {
        User testUser =new User(3,"testFirst","testLast","student","testUser","testpassword","test@test.com","1234567");
        User testUser2 =new User(4,"testFirst","testLast","student","testUser2","testpassword","test2@test.com","1234567");
        byte[] testBytes=new byte[2];
        FileUpload testFileUpload1 = new FileUpload("testFileName",testBytes,"testMimeType");
        FileUpload testFileUpload2 = new FileUpload("testFileNam2",testBytes,"testMimeType");
        Homework testHomeWork = new Homework();
        Report testReport = new Report(testUser,testUser2,testFileUpload1,testFileUpload2,testHomeWork,12,12,12,12);
        testReport.setId(1);
        assertEquals(1,testReport.getId());
    }

    @Test
    public void getUser1() throws Exception {
        User testUser =new User(3,"testFirst","testLast","student","testUser","testpassword","test@test.com","1234567");
        User testUser2 =new User(4,"testFirst","testLast","student","testUser2","testpassword","test2@test.com","1234567");
        byte[] testBytes=new byte[2];
        FileUpload testFileUpload1 = new FileUpload("testFileName",testBytes,"testMimeType");
        FileUpload testFileUpload2 = new FileUpload("testFileNam2",testBytes,"testMimeType");
        Homework testHomeWork = new Homework();
        Report testReport = new Report(testUser,testUser2,testFileUpload1,testFileUpload2,testHomeWork,12,12,12,12);
        assertEquals(testUser,testReport.getUser1());
    }

    @Test
    public void setUser1() throws Exception {
        User testUser =new User(3,"testFirst","testLast","student","testUser","testpassword","test@test.com","1234567");
        User testUser2 =new User(4,"testFirst","testLast","student","testUser2","testpassword","test2@test.com","1234567");
        byte[] testBytes=new byte[2];
        FileUpload testFileUpload1 = new FileUpload("testFileName",testBytes,"testMimeType");
        FileUpload testFileUpload2 = new FileUpload("testFileNam2",testBytes,"testMimeType");
        Homework testHomeWork = new Homework();
        Report testReport = new Report(testUser,testUser2,testFileUpload1,testFileUpload2,testHomeWork,12,12,12,12);
        testReport.setUser1(testUser2);
        assertEquals(testUser2,testReport.getUser1());
    }

    @Test
    public void getSetUser2() throws Exception {
        User testUser =new User(3,"testFirst","testLast","student","testUser","testpassword","test@test.com","1234567");
        User testUser2 =new User(4,"testFirst","testLast","student","testUser2","testpassword","test2@test.com","1234567");
        byte[] testBytes=new byte[2];
        FileUpload testFileUpload1 = new FileUpload("testFileName",testBytes,"testMimeType");
        FileUpload testFileUpload2 = new FileUpload("testFileNam2",testBytes,"testMimeType");
        Homework testHomeWork = new Homework();
        Report testReport = new Report(testUser,testUser2,testFileUpload1,testFileUpload2,testHomeWork,12,12,12,12);
        testReport.setUser2(testUser);
        assertEquals(testUser,testReport.getUser2());
    }

    @Test
    public void getSetHashMapPercentage() throws Exception {
        User testUser =new User(3,"testFirst","testLast","student","testUser","testpassword","test@test.com","1234567");
        User testUser2 =new User(4,"testFirst","testLast","student","testUser2","testpassword","test2@test.com","1234567");
        byte[] testBytes=new byte[2];
        FileUpload testFileUpload1 = new FileUpload("testFileName",testBytes,"testMimeType");
        FileUpload testFileUpload2 = new FileUpload("testFileNam2",testBytes,"testMimeType");
        Homework testHomeWork = new Homework();
        Report testReport = new Report(testUser,testUser2,testFileUpload1,testFileUpload2,testHomeWork,12,12,12,12);
        testReport.setPercentageCompareHashMap(12);
        assertEquals(12,testReport.getPercentageCompareHashMap(),2);
    }

    @Test
    public void getSetTreesPercentage() throws Exception {
        User testUser =new User(3,"testFirst","testLast","student","testUser","testpassword","test@test.com","1234567");
        User testUser2 =new User(4,"testFirst","testLast","student","testUser2","testpassword","test2@test.com","1234567");
        byte[] testBytes=new byte[2];
        FileUpload testFileUpload1 = new FileUpload("testFileName",testBytes,"testMimeType");
        FileUpload testFileUpload2 = new FileUpload("testFileNam2",testBytes,"testMimeType");
        Homework testHomeWork = new Homework();
        Report testReport = new Report(testUser,testUser2,testFileUpload1,testFileUpload2,testHomeWork,12,12,12,12);
        testReport.setpercentageCompareTrees(12);
        assertEquals(12,testReport.getpercentageCompareTrees(),2);
    }

    @Test
    public void getSetLDPercentage() throws Exception {
        User testUser =new User(3,"testFirst","testLast","student","testUser","testpassword","test@test.com","1234567");
        User testUser2 =new User(4,"testFirst","testLast","student","testUser2","testpassword","test2@test.com","1234567");
        byte[] testBytes=new byte[2];
        FileUpload testFileUpload1 = new FileUpload("testFileName",testBytes,"testMimeType");
        FileUpload testFileUpload2 = new FileUpload("testFileNam2",testBytes,"testMimeType");
        Homework testHomeWork = new Homework();
        Report testReport = new Report(testUser,testUser2,testFileUpload1,testFileUpload2,testHomeWork,12,12,12,12);
        testReport.setpercentageCompareLevenshteinDistancep(12);
        assertEquals(12,testReport.getpercentageCompareLevenshteinDistance(),2);
    }


    @Test
    public void getFileUpload1() throws Exception {
        User testUser =new User(3,"testFirst","testLast","student","testUser","testpassword","test@test.com","1234567");
        User testUser2 =new User(4,"testFirst","testLast","student","testUser2","testpassword","test2@test.com","1234567");
        byte[] testBytes=new byte[2];
        FileUpload testFileUpload1 = new FileUpload("testFileName",testBytes,"testMimeType");
        FileUpload testFileUpload2 = new FileUpload("testFileNam2",testBytes,"testMimeType");
        Homework testHomeWork = new Homework();
        Report testReport = new Report(testUser,testUser2,testFileUpload1,testFileUpload2,testHomeWork,12,12,12,12);
        assertEquals(testFileUpload1,testReport.getFileUpload1());
    }

    @Test
    public void setFileUpload1() throws Exception {
        User testUser =new User(3,"testFirst","testLast","student","testUser","testpassword","test@test.com","1234567");
        User testUser2 =new User(4,"testFirst","testLast","student","testUser2","testpassword","test2@test.com","1234567");
        byte[] testBytes=new byte[2];
        FileUpload testFileUpload1 = new FileUpload("testFileName",testBytes,"testMimeType");
        FileUpload testFileUpload2 = new FileUpload("testFileNam2",testBytes,"testMimeType");
        Homework testHomeWork = new Homework();
        Report testReport = new Report(testUser,testUser2,testFileUpload1,testFileUpload2,testHomeWork,12,12,12,12);
        testReport.setFileUpload1(testFileUpload2);
        assertEquals(testFileUpload2,testReport.getFileUpload1());
    }

    @Test
    public void getSetFileUpload2() throws Exception {
        User testUser =new User(3,"testFirst","testLast","student","testUser","testpassword","test@test.com","1234567");
        User testUser2 =new User(4,"testFirst","testLast","student","testUser2","testpassword","test2@test.com","1234567");
        byte[] testBytes=new byte[2];
        FileUpload testFileUpload1 = new FileUpload("testFileName",testBytes,"testMimeType");
        FileUpload testFileUpload2 = new FileUpload("testFileNam2",testBytes,"testMimeType");
        Homework testHomeWork = new Homework();
        Report testReport = new Report(testUser,testUser2,testFileUpload1,testFileUpload2,testHomeWork,12,12,12,12);
        testReport.setFileUpload2(testFileUpload1);
        assertEquals(testFileUpload1,testReport.getFileUpload2());
    }

    @Test
    public void getSetHomework() throws Exception {
        User testUser =new User(3,"testFirst","testLast","student","testUser","testpassword","test@test.com","1234567");
        User testUser2 =new User(4,"testFirst","testLast","student","testUser2","testpassword","test2@test.com","1234567");
        byte[] testBytes=new byte[2];
        FileUpload testFileUpload1 = new FileUpload("testFileName",testBytes,"testMimeType");
        FileUpload testFileUpload2 = new FileUpload("testFileNam2",testBytes,"testMimeType");
        Homework testHomeWork = new Homework();
        Report testReport = new Report(testUser,testUser2,testFileUpload1,testFileUpload2,testHomeWork,12,12,12,12);
        Homework testHomeWork2 = new Homework();
        testReport.setHomework(testHomeWork2);
        assertEquals(testHomeWork2,testReport.getHomework());
    }

    @Test
    public void testDefaultContsructor() throws Exception {
        Report testReport = new Report();
        User testUser =new User(3,"testFirst","testLast","student","testUser","testpassword","test@test.com","1234567");
        testReport.setUser1(testUser);
        assertEquals(3,testReport.getUser1().getId());
    }

    @Test
    public void getSetCompareAllPercentage() throws Exception {
        User testUser =new User(3,"testFirst","testLast","student","testUser","testpassword","test@test.com","1234567");
        User testUser2 =new User(4,"testFirst","testLast","student","testUser2","testpassword","test2@test.com","1234567");
        byte[] testBytes=new byte[2];
        FileUpload testFileUpload1 = new FileUpload("testFileName",testBytes,"testMimeType");
        FileUpload testFileUpload2 = new FileUpload("testFileNam2",testBytes,"testMimeType");
        Homework testHomeWork = new Homework();
        Report testReport = new Report(testUser,testUser2,testFileUpload1,testFileUpload2,testHomeWork,12,12,12,12);
        testReport.setPercentageCompareAll(12);
        assertEquals(12,testReport.getPercentageCompareAll(),2);
    }


}