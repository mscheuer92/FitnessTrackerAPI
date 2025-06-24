package com.fitnesstracker.fitnessTrackerAPI.model;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="workout")
public class Workout {
    @Id private long id;

    private String workoutName;
    private int duration;
    private Date date;

    public void setId(long id) {
        this.id = id;
    }
    public void setWorkoutName(String workoutName) {
        this.workoutName = workoutName;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public long getId() {
        return id;
    }
    public String getWorkoutName() {
        return workoutName;
    }
    public int getDuration() {
        return duration;
    }
    public Date getDate() {
        return date;
    }

}
