package com.northeastern.msd.team102.plagiarismchecker.entity;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {
    @Test
    public void getId() throws Exception {
        User testUser =new User(3,"testFirst","testLast","student","testUser","testpassword","test@test.com","1234567");
        assertEquals(3,testUser.getId());
    }

    @Test
    public void setId() throws Exception {
        User testUser =new User(3,"testFirst","testLast","student","testUser","testpassword","test@test.com","1234567");
        testUser.setId(4);
        assertEquals(4,testUser.getId());
    }

    @Test
    public void getFirstName() throws Exception {
        User testUser =new User(3,"testFirst","testLast","student","testUser","testpassword","test@test.com","1234567");
        assertEquals("testFirst",testUser.getFirstName());
    }

    @Test
    public void setFirstName() throws Exception {
        User testUser =new User(3,"testFirst","testLast","student","testUser","testpassword","test@test.com","1234567");
        testUser.setFirstName("testFirst2");
        assertEquals("testFirst2",testUser.getFirstName());
    }

    @Test
    public void getLastName() throws Exception {
        User testUser =new User(3,"testFirst","testLast","student","testUser","testpassword","test@test.com","1234567");
        assertEquals("testLast",testUser.getLastName());
    }

    @Test
    public void setLastName() throws Exception {
        User testUser =new User(3,"testFirst","testLast","student","testUser","testpassword","test@test.com","1234567");
        testUser.setLastName("testFirst2");
        assertEquals("testFirst2",testUser.getLastName());
    }

    @Test
    public void getUserType() throws Exception {
        User testUser =new User(3,"testFirst","testLast","student","testUser","testpassword","test@test.com","1234567");
        assertEquals("student",testUser.getUserType());
    }

    @Test
    public void setUserType() throws Exception {
        User testUser =new User(3,"testFirst","testLast","student","testUser","testpassword","test@test.com","1234567");
        testUser.setUserType("Professor");
        assertEquals("Professor",testUser.getUserType());
    }

    @Test
    public void getUsername() throws Exception {
        User testUser =new User(3,"testFirst","testLast","student","testUser","testpassword","test@test.com","1234567");
        assertEquals("testUser",testUser.getUsername());
    }

    @Test
    public void setUsername() throws Exception {
        User testUser =new User(3,"testFirst","testLast","student","testUser","testpassword","test@test.com","1234567");
        testUser.setUsername("testUser2");
        assertEquals("testUser2",testUser.getUsername());
    }

    @Test
    public void getPassword() throws Exception {
        User testUser =new User(3,"testFirst","testLast","student","testUser","testpassword","test@test.com","1234567");
        assertEquals("testpassword",testUser.getPassword());
    }

    @Test
    public void setPassword() throws Exception {
        User testUser =new User(3,"testFirst","testLast","student","testUser","testpassword","test@test.com","1234567");
        testUser.setPassword("dummyPAssword");
        assertEquals("dummyPAssword",testUser.getPassword());
    }

    @Test
    public void getEmail() throws Exception {
        User testUser =new User(3,"testFirst","testLast","student","testUser","testpassword","test@test.com","1234567");
        assertEquals("test@test.com",testUser.getEmail());
    }

    @Test
    public void setEmail() throws Exception {
        User testUser =new User(3,"testFirst","testLast","student","testUser","testpassword","test@test.com","1234567");
        testUser.setEmail("test2@test.com");
        assertEquals("test2@test.com",testUser.getEmail());
    }

    @Test
    public void getPhone() throws Exception {
        User testUser =new User(3,"testFirst","testLast","student","testUser","testpassword","test@test.com","1234567");
        assertEquals("1234567",testUser.getPhone());
    }

    @Test
    public void setPhone() throws Exception {
        User testUser =new User(3,"testFirst","testLast","student","testUser","testpassword","test@test.com","1234567");
        testUser.setPhone("1234568");
        assertEquals("1234568",testUser.getPhone());
    }

    @Test
    public void testDefaultConstructor() throws Exception {
        User testUser =new User();
        testUser.setPhone("1234568");
        assertEquals("1234568",testUser.getPhone());
    }

}