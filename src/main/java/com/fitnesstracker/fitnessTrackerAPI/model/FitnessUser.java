package com.fitnesstracker.fitnessTrackerAPI.model;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="fitness_user")
public class FitnessUser {

@NotNull(message="username must not be null")
@NotBlank(message="username must not be blank")

private String username;
@Column(name="user_id")
@Id
private String userID;

public FitnessUser() {
    this.userID = UUID.randomUUID().toString();
}
public String getUsername() {
    return username;
}
public void setUsername(String username) {
    this.username = username;
}
public String getUserID() {
    return userID;
}


}
