package com.blog.service;

import com.blog.service.models.Friend;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
public class SystemTest {

    @Test
    public  void  CreateFrendTest(){

        RestTemplate restTemplate =new RestTemplate();
        String url=  "http://localhost:8080/friend";
        Friend friend= new Friend("priyanshu","Parate");
      ResponseEntity<Friend> result=  restTemplate.postForEntity(url,friend,Friend.class);
        Assert.assertSame(result.getStatusCode(), HttpStatus.OK);

    }
    @Test
    public  void  GetFriendTest(){
        RestTemplate restTemplate =new RestTemplate();
        String url=  "http://localhost:8080/friend";
        createFriend(restTemplate, url);

        Friend[] result=  restTemplate.getForObject(url,Friend[].class);
        Assert.assertSame(result.length, 1);

    }

    private void createFriend(RestTemplate restTemplate, String url) {
        Friend friend= new Friend("priyanshu","Parate");
        ResponseEntity<Friend> result=  restTemplate.postForEntity(url,friend,Friend.class);
//        restTemplate.p
    }
}
