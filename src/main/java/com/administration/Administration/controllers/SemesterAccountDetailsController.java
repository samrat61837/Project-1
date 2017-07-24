/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administration.Administration.controllers;

import com.administration.Administration.models.SemesterAccountDetails;
import com.administration.Administration.repository.SemesterAccountDetailsRepository;
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
@RequestMapping(ApiConstants.BASE_ADMIN_URL+ApiConstants.SEMESTERACCOUNTDETAILS)
public class SemesterAccountDetailsController {
    
  @Autowired
  SemesterAccountDetailsRepository semesteraccountdetailsRepo;
  @RequestMapping(value="list", method=RequestMethod.GET)
    public List<SemesterAccountDetails> getallRoles(){
        return semesteraccountdetailsRepo.findAll();
    }
    @RequestMapping(value="{id}",method=RequestMethod.GET)
    public SemesterAccountDetails getSemesterAccountDetailsById(@PathVariable("id")Long id){
        return semesteraccountdetailsRepo.findOne(id);
    }

    @RequestMapping(value="savesemesteraccountdetails",method=RequestMethod.POST)
    public SemesterAccountDetails saveSemesterAccountDetails (@RequestBody SemesterAccountDetails semesteraccountdetails){
        return semesteraccountdetailsRepo.save(semesteraccountdetails);
    }

    @RequestMapping(value="{id}", method=RequestMethod.DELETE)
public void deleteSemesterAccountDetailsById(@PathVariable long id){
    semesteraccountdetailsRepo.delete(id);
}

}

