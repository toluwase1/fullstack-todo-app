package com.toluwase.appbackend.endpoint;

import com.toluwase.appbackend.models.LoginRequest;
import com.toluwase.appbackend.models.UserRequest;
import com.toluwase.appbackend.models.Users;
import com.toluwase.appbackend.services.ServiceImpl.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UsersEndpoint {
    @Autowired
    private UsersServiceImpl usersService;


    @PostMapping("/login")
    public  ResponseEntity<String> login (@RequestBody LoginRequest loginRequest) throws UserPrincipalNotFoundException {

        Users users = usersService.loginByUsernameAndEmail(loginRequest.getEmailOrUsername(), loginRequest.getPassword());

        if(users == null){
            throw new UserPrincipalNotFoundException("User details not correct");
        }

        return new ResponseEntity<>("Successful", HttpStatus.OK);
    }

    //create a user
    @PostMapping("/create")
    public  ResponseEntity<?> signup (@RequestBody UserRequest users){
        System.err.println("AM here");
        Users user = usersService.signup(users);
        return new ResponseEntity<>("Successful", HttpStatus.OK);
    }

    //method lists all created users
    @GetMapping("/all")
    public List<Users> getAllUsers() {
        return usersService.getAllUsers();
    }

    //get User By ID
    @GetMapping("/{id}")
    public Users getUserById (@PathVariable(value = "id") long userId) {
        return usersService.getUserById(userId);
    }



    //update User
    @PutMapping("/{id}")
    public  Users updateUser (@RequestBody UserRequest user, @PathVariable("id") long userId){
        return usersService.updateUserProfile(user, userId);

    }

    //deletes user
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") long userId){
        usersService.deleteUsers(userId);
        return ResponseEntity.status(HttpStatus.OK).body("User with "+ userId +" deleted");
    }
}
