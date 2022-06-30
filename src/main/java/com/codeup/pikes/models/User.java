package com.codeup.pikes.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private boolean admin;

    @Column(nullable = true)
    private String profPic;


    public User(){}

    public User(User copy){
        id = copy.id;
        username = copy.username;
        password = copy.password;
        email = copy.email;
        admin = copy.admin;
        profPic = copy.profPic;
    }

    public User(long id, String username, String password, String email, boolean admin, String profPic){
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.admin = admin;
        this.profPic = profPic;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getProfPic() {
        return profPic;
    }

    public void setProfPic(String profPic) {
        this.profPic = profPic;
    }
}
