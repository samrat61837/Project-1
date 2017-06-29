/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administration.Administration.controllers;

import com.administration.Administration.models.Student;
import com.administration.Administration.repository.StudentRepository;
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
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentRepository studentRepo;
    
    @RequestMapping(value="/List", method=RequestMethod.GET)
    public List<Student> getAllstudent(){
        return studentRepo.findAll();
    }
}

