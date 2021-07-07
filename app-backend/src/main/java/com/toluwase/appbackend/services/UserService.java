package com.toluwase.appbackend.services;

import com.toluwase.appbackend.models.UserRequest;
import com.toluwase.appbackend.models.Users;

import java.util.List;

public interface UserService {
     Users loginByUsername  (String email, String password);
     Users loginByEmail  (String email, String password);
     Users loginByUsernameAndEmail (String emailOrUsername, String password);
     Users signup (UserRequest userRequest);
     Users getUserById (long id);
     List<Users> getAllUsers ();
     Users updateUserProfile (UserRequest user, long id);
     Users getUserByName(String name);
     void deleteUsers (long id);
}
