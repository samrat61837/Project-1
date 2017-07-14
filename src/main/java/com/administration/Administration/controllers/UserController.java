package com.administration.Administration.controllers;

import com.administration.Administration.models.User;
import com.administration.Administration.repository.UserRepository;
import com.administration.Administration.utils.ApiConstants;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

@RestController
@RequestMapping(ApiConstants.BASE_ADMIN_URL+ApiConstants.USER)
public class UserController {
    
  @Autowired
    UserRepository userRepo;
  @RequestMapping(value="list", method=RequestMethod.GET)
    public List<User> getallUsers(){
        return userRepo.findAll();
    }
    @RequestMapping(value="{id}",method=RequestMethod.GET)
    public User getUserById(@PathVariable("id") int id){
        return userRepo.findOne(id);
}
    @RequestMapping(value="saveuser", method=RequestMethod.POST)
    public User saveUser (@RequestBody User user){
        return userRepo.save(user);
    }
}