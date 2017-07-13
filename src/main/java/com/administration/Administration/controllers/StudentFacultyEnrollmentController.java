/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administration.Administration.controllers;

import com.administration.Administration.models.Semester;
import com.administration.Administration.models.StudentFacultyEnrollment;
import com.administration.Administration.repository.StudentFacultyEnrollmentRepository;
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
@RequestMapping(ApiConstants.BASE_ADMIN_URL+ApiConstants.STUDENTFACULTYENROLLMENT)
public class StudentFacultyEnrollmentController {
    
  @Autowired
    StudentFacultyEnrollmentRepository studentfacultyenrollmentRepo;
  @RequestMapping(value="list", method=RequestMethod.GET)
    public List<StudentFacultyEnrollment> getallStudentFacultyEnrollments(){
        return studentfacultyenrollmentRepo.findAll();
    }
    @RequestMapping(value="{id}",method=RequestMethod.GET)
    public StudentFacultyEnrollment getStudentFacultyEnrollmentById(@PathVariable("id")Long id){
        return studentfacultyenrollmentRepo.findOne(id);
}
     @RequestMapping(value="savestudentfacultyenrollment",method=RequestMethod.POST)
    public StudentFacultyEnrollment saveStudentFacultyEnrollment (@RequestBody StudentFacultyEnrollment studentfacultyenrollment){
        return studentfacultyenrollmentRepo.save(studentfacultyenrollment);
    }
}
