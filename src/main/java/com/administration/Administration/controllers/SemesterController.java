/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administration.Administration.controllers;

import com.administration.Administration.models.Semester;
import com.administration.Administration.repository.SemesterRepository;
import com.administration.Administration.utils.ApiConstants;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Samrat
 */
@RestController
@RequestMapping(ApiConstants.BASE_ADMIN_URL+ApiConstants.SEMESTER)
public class SemesterController {
    
  @Autowired
    SemesterRepository semesterRepo;
  @RequestMapping(value="list", method=RequestMethod.GET)
    public List<Semester> getallSemesters(){
        return semesterRepo.findAll();
    }
    @RequestMapping(value="{id}",method=RequestMethod.GET)
    public Semester getSemesterById(@PathVariable("id")Integer id){
        return semesterRepo.findOne(id);
}
    @RequestMapping(value="/[id]", method=RequestMethod.DELETE)
public void deleteUserBYId(@PathVariable int id){
    semesterRepo.delete(id);
}
}
