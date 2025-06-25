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
    @Id private String id;

    @NotBlank(message= "Workout Type Required")
    private String workoutType;
    @NotNull(message = "Time cannot be null")
    @Positive(message= "Time should be a positive number")
    private int duration;
    private Date date;

    public void generateId() {
        this.id = UUID.randomUUID().toString();
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setWorkoutType(String workoutType) {
        this.workoutType = workoutType;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public String getId() {
        return id;
    }
    public String getWorkoutType() {
        return workoutType;
    }
    public int getDuration() {
        return duration;
    }
    public Date getDate() {
        return date;
    }

}
