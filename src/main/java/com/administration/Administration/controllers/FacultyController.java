/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administration.Administration.controllers;

import com.administration.Administration.models.Faculty;
import com.administration.Administration.repository.FacultyRepository;
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
@RequestMapping(ApiConstants.BASE_ADMIN_URL+ApiConstants.FACULTY)
public class FacultyController {
    
  @Autowired
    FacultyRepository facultyRepo;
  @RequestMapping(value="list", method=RequestMethod.GET)
    public List<Faculty> getallFaculties(){
        return facultyRepo.findAll();
    }
    @RequestMapping(value="{id}",method=RequestMethod.GET)
    public Faculty getFacultyById(@PathVariable("id")Integer id){
        return facultyRepo.findOne(id);
}

    @RequestMapping(value="savefaculty", method=RequestMethod.POST)
    public Faculty saveFaculty (@RequestBody Faculty faculty){
        return facultyRepo.save(faculty);
    }

    @RequestMapping(value="/[id]", method=RequestMethod.DELETE)
public void deleteFacultyBYId(@PathVariable int id){
    facultyRepo.delete(id);
}

}