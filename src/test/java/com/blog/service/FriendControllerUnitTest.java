package com.blog.service;

import com.blog.service.controllers.FriendController;
import com.blog.service.dbservices.FriendService;
import com.blog.service.models.Friend;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(FriendController.class)
public class FriendControllerUnitTest {
    @MockBean
    FriendService friendService;
    @Autowired
    MockMvc mockMvc;

    @Test
    public void CreateFriendTest() {
        //Arrange
        Friend friend = new Friend("Priyanshu", "Parate");
        List<Friend> friends = Arrays.asList(friend);
       // Mokito.Wh
        //Act

        //Assert
    }

    @Test
    public void testStatic() {
        //Arrange
       var s= new Student();
       s.m1();
    }
}
class  Student {

    public  static void   m1(){
        String s="test";
        System.out.println("s" + s.getBytes(StandardCharsets.UTF_8).toString());
    }
}
