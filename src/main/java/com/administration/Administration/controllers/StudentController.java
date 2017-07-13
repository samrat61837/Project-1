/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administration.Administration.controllers;

import com.administration.Administration.models.Semester;
import com.administration.Administration.models.Student;
import com.administration.Administration.repository.StudentRepository;
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
@RequestMapping(ApiConstants.BASE_ADMIN_URL+ApiConstants.STUDENT)
public class StudentController {
    
  @Autowired
    StudentRepository studentRepo;
  @RequestMapping(value="list", method=RequestMethod.GET)
    public List<Student> getallStudents(){
        return studentRepo.findAll();
    }
    @RequestMapping(value="{id}",method=RequestMethod.GET)
    public Student getRoleById(@PathVariable("id")Long id){
        return studentRepo.findOne(id);
}
<<<<<<< HEAD
     @RequestMapping(value="savestudent",method=RequestMethod.POST)
    public Student saveStudent (@RequestBody Student student){
        return studentRepo.save(student);
    }
=======
    @RequestMapping(value="/[id]", method=RequestMethod.DELETE)
public void deleteUserBYId(@PathVariable long id){
    studentRepo.delete(id);
}
>>>>>>> 29f73fbbd61f447f7647b35e19d1e3fbab84c5f3
}

