package com.ironhack.edgeservice.model;

import com.ironhack.edgeservice.enums.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class User {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Role role;
    private List<Integer> investments;
    private List<Integer> comments;

    public User() {
    }

    public User(String firstName, String lastName, String email, String password, Role role, List<Integer> investments, List<Integer> comments) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.investments = investments;
        this.comments = comments;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Integer> getInvestments() {
        return investments;
    }

    public void setInvestments(List<Integer> investments) {
        this.investments = investments;
    }

    public List<Integer> getComments() {
        return comments;
    }

    public void setComments(List<Integer> comments) {
        this.comments = comments;
    }
}
