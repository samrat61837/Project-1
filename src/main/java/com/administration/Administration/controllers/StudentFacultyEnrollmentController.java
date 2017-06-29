/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administration.Administration.controllers;

import com.administration.Administration.models.StudentFacultyEnrollment;
import com.administration.Administration.repository.StudentFacultyEnrollmentRepository;
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
@RequestMapping("/studentFacultyEnrollment")
public class StudentFacultyEnrollmentController {
    @Autowired
    StudentFacultyEnrollmentRepository StudentFacultyEnrollmentRepo;
    
    @RequestMapping(value="/List", method=RequestMethod.GET)
    public List<StudentFacultyEnrollment> getAllStudentFacultyEnrollment(){
        return StudentFacultyEnrollmentRepo.findAll();
    }
}
