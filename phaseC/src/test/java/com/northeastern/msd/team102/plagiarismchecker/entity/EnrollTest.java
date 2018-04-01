package com.northeastern.msd.team102.plagiarismchecker.entity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test cases for enroll entity
 */
public class EnrollTest {
    @Test
    public void getId() throws Exception {
        User testUser =new User(3,"testFirst","testLast","student","testUser","testpassword","test@test.com");
        Course testCourse = new Course("courseName","courseDescrition",testUser);
        Enroll testEnroll = new Enroll(testUser,testCourse);
        assertEquals(0,testEnroll.getId());
    }

    @Test
    public void setId() throws Exception {
        User testUser =new User(3,"testFirst","testLast","student","testUser","testpassword","test@test.com");
        Course testCourse = new Course("courseName","courseDescrition",testUser);
        Enroll testEnroll = new Enroll(testUser,testCourse);
        testEnroll.setId(3);
        assertEquals(3,testEnroll.getId());
    }

    @Test
    public void getUser() throws Exception {
        User testUser =new User(3,"testFirst","testLast","student","testUser","testpassword","test@test.com");
        Course testCourse = new Course("courseName","courseDescrition",testUser);
        Enroll testEnroll = new Enroll(testUser,testCourse);
        assertEquals(testUser,testEnroll.getUser());
    }

    @Test
    public void setUser() throws Exception {
        User testUser =new User(3,"testFirst","testLast","student","testUser","testpassword","test@test.com");
        User testUser1 =new User(4,"testFirst1","testLast1","student","testUser1","testpassword","test@test.com");
        Course testCourse = new Course("courseName","courseDescrition",testUser);
        Enroll testEnroll = new Enroll(testUser,testCourse);
        testEnroll.setUser(testUser1);
        assertEquals(testUser1,testEnroll.getUser());
    }

    @Test
    public void getCourse() throws Exception {
        User testUser =new User(3,"testFirst","testLast","student","testUser","testpassword","test@test.com");
        Course testCourse = new Course("courseName","courseDescrition",testUser);
        Enroll testEnroll = new Enroll(testUser,testCourse);
        assertEquals(testCourse,testEnroll.getCourse());
    }

    @Test
    public void setCourse() throws Exception {
        User testUser =new User(3,"testFirst","testLast","student","testUser","testpassword","test@test.com");
        Course testCourse = new Course("courseName","courseDescrition",testUser);
        Course testCourse2 = new Course("courseName2","courseDescrition2",testUser);
        Enroll testEnroll = new Enroll(testUser,testCourse);
        testEnroll.setCourse(testCourse2);
        assertEquals(testCourse2,testEnroll.getCourse());
    }

    @Test
    public void testDefaultConstructor() throws Exception {
        Enroll testEnroll = new Enroll();
        User testUser =new User(3,"testFirst","testLast","student","testUser","testpassword","test@test.com");
        Course testCourse = new Course("courseName","courseDescrition",testUser);
        testEnroll.setCourse(testCourse);
        assertEquals(testCourse,testEnroll.getCourse());
    }

}