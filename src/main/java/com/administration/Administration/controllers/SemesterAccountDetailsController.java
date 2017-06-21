/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administration.Administration.controllers;

import com.administration.Administration.models.Account;
import com.administration.Administration.repository.AccountRepository;
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
@RequestMapping("/semesterAccountDetails")
public class SemesterAccountDetailsController {
    @Autowired
   SemesterAccountDetailsRepository semesterAccountDetailsRepo;
    
    @RequestMapping(value="/List", method=RequestMethod.GET)
    public List<SemesterAccountDetails> getAllemesterAccountDetails(){
        return semesterAccountDetailsRepo.findAll();
    }
}
