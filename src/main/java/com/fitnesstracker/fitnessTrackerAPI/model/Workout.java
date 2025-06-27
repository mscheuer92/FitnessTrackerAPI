package com.fitnesstracker.fitnessTrackerAPI.model;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;


@Entity
@Table(name="workout")
public class Workout {
    @Column(name="workout_id") 
    @Id 
    private final String workoutID;
    
    @NotBlank(message= "Workout Type Required")
    private String workoutType;
    
    @NotNull(message = "Time cannot be null")
    @Positive(message= "Time should be a positive number")

    private Date date;
    @OneToMany(mappedBy="workout", cascade=CascadeType.ALL, orphanRemoval=true)
    @JsonManagedReference
    private List<Exercise> exercises = new ArrayList<>();

    public Workout() {
        this.workoutID = UUID.randomUUID().toString();
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
