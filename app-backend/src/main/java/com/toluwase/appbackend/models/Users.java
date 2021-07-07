package com.toluwase.appbackend.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
public class Users extends BaseModel{

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phoneNumber", unique = true)
    private String phoneNumber;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "username", unique = true)
    private String username;

    @OneToMany
    private List<Todos>  todos;

    public Users(String email, String password, long id) {
        super(id);
        this.email = email;
        this.password = password;
    }

    public Users() {
        super();
    }
}


