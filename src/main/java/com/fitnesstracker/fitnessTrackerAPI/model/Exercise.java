package com.fitnesstracker.fitnessTrackerAPI.model;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name="exercise")
public class Exercise {
@Column(name="exercise_id")    
@Id 
private String exerciseID;

@NotBlank(message= "Exerise name cannot be blank")
 private String exerciseName;

@NotBlank(message= "Exerise duration cannot be blank")
@Positive(message="Exercise duration must be a positive number")
private int exerciseDuration;

@JoinColumn(name = "workout_id", nullable = false)

@ManyToOne
@JsonBackReference

private Workout workout;

public void generateId() {
    this.exerciseID = UUID.randomUUID().toString();
}

 public String getExerciseID() {
    return exerciseID;
 }
 public void setExerciseID(String exerciseID) {
    this.exerciseID = exerciseID;
 }

public Workout getWorkout() {
    return workout;
    }

public void setWorkout(Workout workout) {
    this.workout = workout;
    }


public int getExerciseDuration() {
    return exerciseDuration;
}

public void setExerciseDuration(int exerciseDuration) {
    this.exerciseDuration = exerciseDuration;
}

 public String getExerciseName() {
    return exerciseName;
 }
 public void setExerciseName(String exerciseName) {
    this.exerciseName = exerciseName;
 }
 

}
