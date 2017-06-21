/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administration.Administration.controllers;

import com.administration.Administration.models.Role;
import com.administration.Administration.repository.RoleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Samrat
 */
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    RoleRepository roleRepo;
    
    @RequestMapping(value="/List", method=RequestMethod.GET)
    public List<Role> getAllRoles(){
        return roleRepo.findAll();
    }
}
