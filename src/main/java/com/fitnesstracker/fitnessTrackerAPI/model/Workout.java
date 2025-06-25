package com.fitnesstracker.fitnessTrackerAPI.model;
import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;


@Entity
@Table(name="workout")
public class Workout {
    @Id private String workoutID;
    @NotBlank(message= "Workout Type Required")
    private String workoutType;
    @NotNull(message = "Time cannot be null")
    @Positive(message= "Time should be a positive number")
    private Date date;
    
    public void generateId() {
        this.workoutID = UUID.randomUUID().toString();
    }

    public void setWorkoutID(String workoutID) {
        this.workoutID = workoutID;
    }
    public void setWorkoutType(String workoutType) {
        this.workoutType = workoutType;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public String getWorkoutID() {
        return workoutID;
    }
    public String getWorkoutType() {
        return workoutType;
    }
    public Date getDate() {
        return date;
    }

}
