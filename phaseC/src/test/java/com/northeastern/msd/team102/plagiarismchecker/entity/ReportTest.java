package com.northeastern.msd.team102.plagiarismchecker.entity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test suite for Report entity
 */
public class ReportTest {


    @Test
    public void getSetId() throws Exception {
        byte[] testBytes=new byte[2];
        File testFile1 = new File("testFileName",testBytes,"testMimeType");
        File testFile2 = new File("testFileNam2",testBytes,"testMimeType");
        Report testReport = new Report(testFile1, testFile2,12,12,12,12);
        testReport.setId(1);
        assertEquals(1,testReport.getId());
    }

    @Test
    public void getSetHashMapPercentage() throws Exception {
        byte[] testBytes=new byte[2];
        File testFile1 = new File("testFileName",testBytes,"testMimeType");
        File testFile2 = new File("testFileNam2",testBytes,"testMimeType");
        Report testReport = new Report(testFile1, testFile2,12,12,12,12);
        testReport.setPercentageCompareHashMap(12);
        assertEquals(12,testReport.getPercentageCompareHashMap(),2);
    }

    @Test
    public void getSetTreesPercentage() throws Exception { ;
        byte[] testBytes=new byte[2];
        File testFile1 = new File("testFileName",testBytes,"testMimeType");
        File testFile2 = new File("testFileNam2",testBytes,"testMimeType");
        Report testReport = new Report(testFile1, testFile2,12,12,12,12);
        testReport.setpercentageCompareTrees(12);
        assertEquals(12,testReport.getpercentageCompareTrees(),2);
    }

    @Test
    public void getSetLDPercentage() throws Exception {
        byte[] testBytes=new byte[2];
        File testFile1 = new File("testFileName",testBytes,"testMimeType");
        File testFile2 = new File("testFileNam2",testBytes,"testMimeType");
        Report testReport = new Report(testFile1, testFile2,12,12,12,12);
        testReport.setpercentageCompareLevenshteinDistancep(12);
        assertEquals(12,testReport.getpercentageCompareLevenshteinDistance(),2);
    }


    @Test
    public void getFileUpload1() throws Exception {
        byte[] testBytes=new byte[2];
        File testFile1 = new File("testFileName",testBytes,"testMimeType");
        File testFile2 = new File("testFileNam2",testBytes,"testMimeType");
        Report testReport = new Report(testFile1, testFile2,12,12,12,12);
        assertEquals(testFile1,testReport.getFile1());
    }

    @Test
    public void setFileUpload1() throws Exception {
        byte[] testBytes=new byte[2];
        File testFile1 = new File("testFileName",testBytes,"testMimeType");
        File testFile2 = new File("testFileNam2",testBytes,"testMimeType");
        Report testReport = new Report(testFile1, testFile2,12,12,12,12);
        testReport.setFile1(testFile2);
        assertEquals(testFile2,testReport.getFile1());
    }

    @Test
    public void getSetFileUpload2() throws Exception {
        byte[] testBytes=new byte[2];
        File testFile1 = new File("testFileName",testBytes,"testMimeType");
        File testFile2 = new File("testFileNam2",testBytes,"testMimeType");
        Report testReport = new Report(testFile1, testFile2,12,12,12,12);
        testReport.setFile2(testFile1);
        assertEquals(testFile1,testReport.getFile2());
    }

    @Test
    public void getSetCompareAllPercentage() throws Exception {
        byte[] testBytes=new byte[2];
        File testFile1 = new File("testFileName",testBytes,"testMimeType");
        File testFile2 = new File("testFileNam2",testBytes,"testMimeType");
        Homework testHomeWork = new Homework();
        Report testReport = new Report(testFile1, testFile2,12,12,12,12);
        testReport.setPercentageCompareAll(12);
        assertEquals(12,testReport.getPercentageCompareAll(),2);
    }
}