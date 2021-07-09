package com.toluwase.appbackend.services.ServiceImpl;

import com.toluwase.appbackend.exception.ResourceNotFoundException;
import com.toluwase.appbackend.models.UserRequest;
import com.toluwase.appbackend.models.Users;
import com.toluwase.appbackend.repositories.UsersRepository;
import com.toluwase.appbackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UserService {
    private UsersRepository usersRepository;

    @Autowired
    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public Users loginByUsername(String username, String password) {
        return usersRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public Users loginByEmail(String email, String password) {
        return usersRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public Users loginByUsernameAndEmail(String emailOrUsername, String password) {

        if (usersRepository.findByEmailAndPassword(emailOrUsername, password) != null){
            return usersRepository.findByEmailAndPassword(emailOrUsername, password);
        }
        return usersRepository.findByUsernameAndPassword(emailOrUsername, password);
    }


    @Override
    public Users signup(UserRequest userRequest) {
        Users users = new Users();
        users.setEmail(userRequest.getEmail());
        users.setFirstName(userRequest.getFirstName());
        users.setLastName(userRequest.getLastName());
        users.setUsername(userRequest.getUsername());
        users.setPassword(userRequest.getPassword());
        users.setPhoneNumber(userRequest.getPhoneNumber());
        System.err.println(userRequest.getPhoneNumber());

        return usersRepository.save(users);
    }

    @Override
    public Users getUserById(@PathVariable(value = "id") long usersId) {
        return this.usersRepository.findById(usersId).
                orElseThrow(()-> new ResourceNotFoundException("User with ID" + usersId +" not found"));
    }

    @Override
    public List<Users> getAllUsers() {
        return this.usersRepository.findAll();
    }


    @Override
    public Users getUserByName(String name) {
        return usersRepository.findUserByFirstName(name);
    }

    @Override
    public void deleteUsers(long id) {
       Optional<Users> user = usersRepository.findById(id);
        this.usersRepository.delete(user.get());
    }


}
