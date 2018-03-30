package com.northeastern.msd.team102.plagiarismchecker.entity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test cases for Course entity
 */
public class CourseTest {

    @Test
    public void getId() throws Exception {
        User testUser =new User(3,"testFirst","testLast","student","testUser","testpassword","test@test.com");
        Course testCourse = new Course("courseName","courseDescrition",testUser);
        assertEquals(0,testCourse.getId());
    }

    @Test
    public void setId() throws Exception {
        User testUser =new User(3,"testFirst","testLast","student","testUser","testpassword","test@test.com");
        Course testCourse = new Course("courseName","courseDescrition",testUser);
        testCourse.setId(4);
        assertEquals(4,testCourse.getId());
    }

    @Test
    public void getName() throws Exception {
        User testUser =new User(3,"testFirst","testLast","student","testUser","testpassword","test@test.com");
        Course testCourse = new Course("courseName","courseDescrition",testUser);
        assertEquals("courseName",testCourse.getName());
    }

    @Test
    public void setName() throws Exception {
        User testUser =new User(3,"testFirst","testLast","student","testUser","testpassword","test@test.com");
        Course testCourse = new Course("courseName","courseDescrition",testUser);
        testCourse.setName("dummyCourseName");
        assertEquals("dummyCourseName",testCourse.getName());
    }

    @Test
    public void getDescription() throws Exception {
        User testUser =new User(3,"testFirst","testLast","student","testUser","testpassword","test@test.com");
        Course testCourse = new Course("courseName","courseDescrition",testUser);
        assertEquals("courseDescrition",testCourse.getDescription());
    }

    @Test
    public void setDescription() throws Exception {
        User testUser =new User(3,"testFirst","testLast","student","testUser","testpassword","test@test.com");
        Course testCourse = new Course("courseName","courseDescrition",testUser);
        testCourse.setDescription("DummyDescription");
        assertEquals("DummyDescription",testCourse.getDescription());
    }

    @Test
    public void getUser() throws Exception {
        User testUser =new User(3,"testFirst","testLast","student","testUser","testpassword","test@test.com");
        Course testCourse = new Course("courseName","courseDescrition",testUser);
        assertEquals(testUser,testCourse.getUser());
    }

    @Test
    public void setUser() throws Exception {
        User testUser =new User(3,"testFirst","testLast","student","testUser","testpassword","test@test.com");
        User testUser1 =new User(4,"testFirst1","testLast1","student","testUser","testpassword","test@test.com");
        Course testCourse = new Course("courseName","courseDescrition",testUser);
        testCourse.setUser(testUser1);
        assertEquals(testUser1,testCourse.getUser());
    }

    @Test
    public void testDefaultConstructor() throws Exception {
        Course testCourse = new Course();
        testCourse.setName("dummyCourse");
        assertEquals("dummyCourse",testCourse.getName());
    }
}