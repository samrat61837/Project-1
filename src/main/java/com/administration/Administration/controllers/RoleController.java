/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administration.Administration.controllers;

import com.administration.Administration.models.Role;
import com.administration.Administration.repository.RoleRepository;
import com.administration.Administration.utils.ApiConstants;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Samrat
 */
@RestController
@RequestMapping(ApiConstants.BASE_ADMIN_URL+ApiConstants.ROLE)
public class RoleController {
    
  @Autowired
    RoleRepository roleRepo;
  @RequestMapping(value="list", method=RequestMethod.GET)
    public List<Role> getallRoles(){
        return roleRepo.findAll();
    }
    @RequestMapping(value="{id}",method=RequestMethod.GET)
    public Role getRoleById(@PathVariable("id")Integer id){
        return roleRepo.findOne(id);
}
    @RequestMapping(value="saverole", method=RequestMethod.POST)
    public Role saveRole (@RequestBody Role role){
        return roleRepo.save(role);
    }
    
    @RequestMapping(value="id", method=RequestMethod.DELETE)
    public void deleteRoleById(@PathVariable int id){
        roleRepo.delete(id);
}
}