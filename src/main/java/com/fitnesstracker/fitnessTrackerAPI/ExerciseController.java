package com.fitnesstracker.fitnessTrackerAPI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fitnesstracker.fitnessTrackerAPI.model.Exercise;
import com.fitnesstracker.fitnessTrackerAPI.model.Workout;
import com.fitnesstracker.fitnessTrackerAPI.repo.ExerciseRepo;
import com.fitnesstracker.fitnessTrackerAPI.repo.WorkoutRepo;



@RestController
public class ExerciseController {
    // POST by Workout ID - add an exercise to a Workout /workout/{workoutID}/exercise -- Done
    // GET all exercises List<Exercise> /exercise -- Done
    // GET individual exercise /exercise/{id} -- Done
    // PUT exercise /workout/{id}/exercise/{id} -- Done
    // DELETE exervise /workout/{id}/exercise/{id} -- Done

    @Autowired
    ExerciseRepo exerciseRepo;
   
    @Autowired
    WorkoutRepo workoutRepo;

    @PostMapping("/workout/{workoutID}/exercise")
    public ResponseEntity<Exercise> addExercise(@PathVariable String workoutID, @RequestBody Exercise exercise) {
        Optional<Workout> workoutOpt = workoutRepo.findById(workoutID);
        if (workoutOpt.isPresent()){
            Workout workout = workoutOpt.get();
            exercise.setWorkout(workout);
            Exercise savedExercise = exerciseRepo.save(exercise);
            return new ResponseEntity<>(savedExercise, HttpStatus.CREATED);    
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }    

    @GetMapping("/exercise")
    public List<Exercise> getAllExercises(){
        return exerciseRepo.findAll();
    }

    @GetMapping("/exercise/{exerciseID}")
    public ResponseEntity<Exercise> getExercise(@PathVariable String exerciseID){
        Optional <Exercise> exercise = exerciseRepo.findById(exerciseID);
        if (exercise.isPresent()){
            return(ResponseEntity.ok(exercise.get()));
        }
        else{
            return ResponseEntity.notFound().build();
        }

    }

    @PutMapping("/exercise/{exerciseID}")
    public ResponseEntity<Exercise> updateExercise(@PathVariable String exerciseID, @RequestBody Exercise exerciseDetails ) {
        Optional<Exercise> exercise = exerciseRepo.findById(exerciseID);
        if (exercise.isPresent()){
            Exercise existingExercise = exercise.get();
            if (exerciseDetails.getExerciseName()!= null){
                existingExercise.setExerciseName(exerciseDetails.getExerciseName());    
            }
            if (exerciseDetails.getExerciseDurationMin() != 0){
                existingExercise.setExerciseDurationMin(exerciseDetails.getExerciseDurationMin());
            }
        
            if (exerciseDetails.getSets() != 0){
                existingExercise.setSets(exerciseDetails.getSets());
            }
        
            if (exerciseDetails.getReps() != 0){
                existingExercise.setReps(exerciseDetails.getReps());
            }
            Exercise updatedExercise = exerciseRepo.save(existingExercise);
            return new ResponseEntity<>(updatedExercise, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/exercise/{exerciseID}")
    public ResponseEntity<Exercise> deleteExercise(@PathVariable String exerciseID){
        Optional <Exercise> exercise = exerciseRepo.findById(exerciseID);
        if (exercise.isPresent()){
            exerciseRepo.deleteById(exerciseID);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    
    
    }

    }