package com.fitnesstracker.fitnessTrackerAPI;
import java.util.Optional;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fitnesstracker.fitnessTrackerAPI.model.Exercise;
import com.fitnesstracker.fitnessTrackerAPI.model.Workout;
import com.fitnesstracker.fitnessTrackerAPI.repo.ExerciseRepo;
import com.fitnesstracker.fitnessTrackerAPI.repo.WorkoutRepo;


@RestController
public class ExerciseController {
    // POST by Workout ID - add an exercise to a Workout /workout/exercise
    // GET all exercises List<Exercise> /workout/exercise
    // GET individual exercise /workout/{id}/exercise/{id}
    // PUT exercise /workout/{id}/exercise/{id}
    // DELETE exervise /workout/{id}/exercise/{id}
    @Autowired
    ExerciseRepo exerciseRepo;
   
    @Autowired
    WorkoutRepo workoutRepo;

    @PostMapping("/workout/{workoutID}/exercise")
    public ResponseEntity<Exercise> addExercise(@PathVariable String workoutID, @RequestBody Exercise exercise) {
        Optional<Workout> workoutOpt = workoutRepo.findById(workoutID);
        exercise.generateId();
        if (workoutOpt.isPresent()){
            Workout workout = workoutOpt.get();
            exercise.setWorkout(workout);
            Exercise savedExercise = exerciseRepo.save(exercise);
            return new ResponseEntity<>(savedExercise, HttpStatus.CREATED);    
        }
        else{
            return ResponseEntity.notFound().build();
        }


    }}
