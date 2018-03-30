package com.northeastern.msd.team102.plagiarismchecker.controller;

import com.northeastern.msd.team102.plagiarismchecker.entity.User;
import com.northeastern.msd.team102.plagiarismchecker.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.springframework.data.repository.init.ResourceReader.Type.JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(value = UserController.class, secure = false)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void login() throws Exception {
        User mockUser = new User(1, "Aditya","Kumar","Student","adi", "adi","adidkool1@gmail.com");
        Mockito.when(userService.findUserByCredentials(Mockito.any(User.class))).thenReturn(mockUser);
        String testJson = "{\"id\":\"1\",\"firstName\":\"Aditya\",\"lastName\":\"Kumar\",\"userType\":\"Student\",\"username\":\"adi\",\"password\":\"adi\",\"email\":\"adidkool1@gmail.com\"}";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(
                "/rest/user/login").accept(MediaType.APPLICATION_JSON).content(testJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "{id:1,firstName:Aditya,lastName:Kumar,userType:Student,username:adi,password:adi,email:adidkool1@gmail.com}";
        JSONAssert.assertEquals(expected, result.getResponse()
                .getContentAsString(), false);
    }

    @Test
    public void findUserByUsername() throws Exception{
        String username = "testUser";
        String ExpectedOutput="{\"id\":3,\"firstName\":\"testFirst\",\"lastName\":\"testLast\",\"userType\":\"student\",\"username\":\"testUser\",\"password\":\"testpassword\",\"email\":\"test@test.com\"}";
        User testUser =new User(3,"testFirst","testLast","student","testUser","testpassword","test@test.com");
        Mockito.when(userService.findUserByUsername(username)).thenReturn(testUser);
        MvcResult result;
        result=mockMvc.perform(MockMvcRequestBuilders.get("/rest/user/findUserByUsername").param("username",username))
                .andExpect(status().isOk())
                .andReturn();
        assertEquals(ExpectedOutput, result.getResponse().getContentAsString());
    }

    @Test
    public void findUserByUserId() throws Exception{
        long userId = 3;
        String suserId ="3";
        String ExpectedOutput="{\"id\":3,\"firstName\":\"testFirst\",\"lastName\":\"testLast\",\"userType\":\"student\",\"username\":\"testUser\",\"password\":\"testpassword\",\"email\":\"test@test.com\"}";
        User testUser =new User(3,"testFirst","testLast","student","testUser","testpassword","test@test.com");
        Mockito.when(userService.findUserByUserId(userId)).thenReturn(testUser);
        MvcResult result;
        result=mockMvc.perform(MockMvcRequestBuilders.get("/rest/user/findUserByUserId").param("userId",suserId))
                .andExpect(status().isOk())
                .andReturn();
        assertEquals(ExpectedOutput, result.getResponse().getContentAsString());
    }

    @Test
    public void findProfessor() throws Exception{
        String ExpectedOutput="{\"id\":3,\"firstName\":\"testFirst\",\"lastName\":\"testLast\",\"userType\":\"student\",\"username\":\"testUser\",\"password\":\"testpassword\",\"email\":\"test@test.com\"}";
        User testProfessor =new User(3,"testFirst","testLast","student","testUser","testpassword","test@test.com");
        Mockito.when(userService.findByUserType("Professor")).thenReturn(testProfessor);
        MvcResult result;
        result=mockMvc.perform(MockMvcRequestBuilders.get("/rest/user/findProfessor"))
                .andExpect(status().isOk())
                .andReturn();
        assertEquals(ExpectedOutput, result.getResponse().getContentAsString());
    }

    @Test
    public void registerUser() throws Exception {
        User mockUser = new User(1, "Aditya","Kumar","Student","adi", "adi","adidkool1@gmail.com");
        Mockito.when(
                userService.createUser(Mockito.any(User.class))).thenReturn(mockUser);
        String testJson = "{\"id\":\"1\",\"firstName\":\"Aditya\",\"lastName\":\"Kumar\",\"userType\":\"Student\",\"username\":\"adi\",\"password\":\"adi\",\"email\":\"adidkool1@gmail.com\"}";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(
                "/rest/user/registerUser").accept(MediaType.APPLICATION_JSON).content(testJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "{id:1,firstName:Aditya,lastName:Kumar,userType:Student,username:adi,password:adi,email:adidkool1@gmail.com}";
        JSONAssert.assertEquals(expected, result.getResponse()
                .getContentAsString(), false);
    }
}