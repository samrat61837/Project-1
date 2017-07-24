/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administration.Administration.controllers;

import com.administration.Administration.models.Account;
import com.administration.Administration.repository.AccountRepository;
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
@RequestMapping(ApiConstants.BASE_ADMIN_URL+ApiConstants.ACCOUNT)
public class AccountController {
    
  @Autowired
    AccountRepository accountRepo;
  @RequestMapping(value="list", method=RequestMethod.GET)
    public List<Account> getallAccounts(){
        return accountRepo.findAll();
    }
    @RequestMapping(value="{id}",method=RequestMethod.GET)
    public Account getAccountById(@PathVariable("id")Long id){
    return accountRepo.findOne(id);
    }

    @RequestMapping(value="saveaccount", method=RequestMethod.POST)
    public Account saveAccount (@RequestBody Account account){
        return accountRepo.save(account);
    }



@RequestMapping(value="{id}", method=RequestMethod.DELETE)
public void deleteAccountById(@PathVariable Long id){
    accountRepo.delete(id);

}
}