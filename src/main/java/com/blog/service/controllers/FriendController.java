package com.blog.service.controllers;

import com.blog.service.dbservices.FriendService;
import com.blog.service.models.ErrorMessage;
import com.blog.service.models.Friend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.bind.ValidationException;
import java.util.ArrayList;

@RestController
public class FriendController {
    @Autowired
    FriendService friendService;

    @GetMapping("/seed")
    public boolean seedData() {
        if (friendService.count() == 0) {
            var friend1 = new Friend();
            friend1.setFirstName("Shambhu");
            friend1.setLastName("Parate");
            var friend2 = new Friend();
            friend2.setFirstName("Priya");
            friend2.setLastName("Parate");
            var friend3 = new Friend();
            friend3.setFirstName("Priyanshu");
            friend3.setLastName("Parate");
            var list = new ArrayList<Friend>();
            list.add(friend1);
            list.add(friend2);
            list.add(friend3);
            friendService.saveAll(list);

        }
        return true;
    }

    @GetMapping("/friend")
    public Iterable<Friend> getAll() throws Exception {

        return friendService.findAll();
    }

    @GetMapping("/friend/{id}")
    public Friend Get(@PathVariable Integer id) {

        var result = friendService.findById(id);
        return result.isPresent() ? result.get() : null;

    }

    @GetMapping("/friend/getByName/{firstName}")
    public Friend getByname(@PathVariable(name = "firstName") String firstName) {

        return friendService.findByFirstName(firstName);
    }

    @PutMapping("/friend/{id}")
    public ResponseEntity<Friend> Update(@PathVariable(value = "id", required = true) int id,@Valid @RequestBody Friend friend) {

        return new ResponseEntity(friendService.save(friend), HttpStatus.OK);
    }

    @PostMapping("/friend")
    public Friend Create(@Valid @RequestBody Friend friend) {
        return friendService.save(friend);
    }

}
