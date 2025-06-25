package com.fitnesstracker.fitnessTrackerAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fitnesstracker.fitnessTrackerAPI.model.Workout;
import com.fitnesstracker.fitnessTrackerAPI.repo.WorkoutRepo;


@RestController
public class WorkoutController {
    @Autowired 
    WorkoutRepo repo;

    @PostMapping("/workout")
    public ResponseEntity <Workout> addWorkout(@RequestBody Workout workout) {
        Workout savedWorkout = repo.save(workout);
        return new ResponseEntity<>(savedWorkout, HttpStatus.CREATED);        
    }
    



}
