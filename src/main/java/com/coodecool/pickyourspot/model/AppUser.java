package com.coodecool.pickyourspot.model;

import java.beans.Transient;
import java.util.Objects;
import java.util.UUID;

public class AppUser {
    private UUID id;
    private String username;
    private transient String email;

    private transient String password;

//    public AppUser(){
//    }

    public AppUser(String username, String email, String hashedPassword) {
        this.id = UUID.randomUUID();
        this.username = username;
        this.email = email;
        this.password = hashedPassword;
    }
/*
    public User(UUID id, String username, String email, String hashedPassword) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = hashedPassword;
    }

*/

    public String getUsername() {
        return username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUser appUser = (AppUser) o;
        return Objects.equals(id, appUser.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", hashedPassword='" + password + '\'' +
                '}';
    }

    public UUID getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
