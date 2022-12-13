package com.coodecool.pickyourspot.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.beans.Transient;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AppUser {
    @Id
//    @Type(type = "uuid-char")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String username;
    private String email;

    private String password;

//    @OneToMany
//    private List<Reservation> reservations;

//    public AppUser(){
//    }

//    @JsonCreator
//    public AppUser(String username, String email, String password) {
//        this.username = username;
//        this.email = email;
//        var hashedPassword = hash(password);
//        this.password = hashedPassword;
//    }
/*
    public User(UUID id, String username, String email, String hashedPassword) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = hashedPassword;
    }
*/

    private String hash(String password) {
        // TODO: remove this eventually
        return password;
    }
//    public String getUsername() {
//        return username;
//    }

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

//    public Long getId() {
//        return id;
//    }
//
//    @JsonIgnore
//    public String getEmail() {
//        return email;
//    }
//
//    @JsonIgnore
//    public String getPassword() {
//        return password;
//    }
//
//    public void setId(UUID id) {
//        this.id = id;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    @JsonProperty
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    @JsonProperty
//    public void setPassword(String password) {
//        this.password = password;
//    }
}
