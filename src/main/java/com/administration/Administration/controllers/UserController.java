
import com.administration.Administration.models.User;
import com.administration.Administration.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository userRepo;
    
    @RequestMapping(value="/List", method=RequestMethod.GET)
    public List<User> getAllUser(){
        return userRepo.findAll();
    }
}
