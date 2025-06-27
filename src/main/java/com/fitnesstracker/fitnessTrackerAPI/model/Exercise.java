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
private final String exerciseID;

@NotBlank(message= "Exerise name cannot be blank")
 private String exerciseName;

@NotBlank(message= "Exercise duration cannot be blank")
@Positive(message="Exercise duration must be a positive number")
private int exerciseDurationMin;

@Positive(message="The number of sets must be positive")
private int sets;

@Positive(message="The number of reps must be positive")
private int reps;

@Positive(message="Distance ran must be a positive number")
private double distanceRanMiles;

@Positive(message="Weight lifted must be a positive number")
private double weightLiftedPounds;


@JoinColumn(name = "workout_id", nullable = false)

@ManyToOne
@JsonBackReference

private Workout workout;

public Exercise() {
    this.exerciseID = UUID.randomUUID().toString();
}

public double getDistanceRanMiles() {
    return distanceRanMiles;
}

public void setDistanceRanMiles(double distanceRanMiles) {
    this.distanceRanMiles = distanceRanMiles;
}

public double getWeightLiftedPounds() {
    return weightLiftedPounds;
}

public void setWeightLiftedPounds(double weightLiftedPounds) {
    this.weightLiftedPounds = weightLiftedPounds;
}

public int getSets() {
    return sets;
}

public void setSets(int sets) {
    this.sets = sets;
}

public int getReps() {
    return reps;
}

public void setReps(int reps) {
    this.reps = reps;
}

 public String getExerciseID() {
    return exerciseID;
 }

public Workout getWorkout() {
    return workout;
    }

public void setWorkout(Workout workout) {
    this.workout = workout;
    }

public void setExerciseDurationMin(int exerciseDurationMin) {
    this.exerciseDurationMin = exerciseDurationMin;
}

public int getExerciseDurationMin() {
    return exerciseDurationMin;
}
 public String getExerciseName() {
    return exerciseName;
 }
 public void setExerciseName(String exerciseName) {
    this.exerciseName = exerciseName;
 }
 

}
