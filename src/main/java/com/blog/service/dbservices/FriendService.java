package com.blog.service.dbservices;

import com.blog.service.models.Friend;
import org.springframework.data.repository.CrudRepository;

public interface FriendService extends CrudRepository<Friend,Integer> {


    Friend findByFirstName(String firstName);

}
