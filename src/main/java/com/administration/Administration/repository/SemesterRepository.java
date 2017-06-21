/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administration.Administration.repository;

import com.administration.Administration.models.Semester;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Samrat
 */
public interface SemesterRepository extends JpaRepository<Semester,Integer> {
    
}
