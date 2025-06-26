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

import com.fitnesstracker.fitnessTrackerAPI.model.Workout;
import com.fitnesstracker.fitnessTrackerAPI.repo.WorkoutRepo;


@RestController
public class WorkoutController {
    @Autowired 
    WorkoutRepo repo;
    // POST addWorkout /workout -- DONE
    // GET List<workout> /workouts -- DONE
    // GET workout/{workoutID} -- DONE
    // GET List<Workout> /workout/{workoutID}/exercise - List workout with its exercises
    // PUT workout/{workoutID} -- DONE 
    // DElETE workout/{workoutID} -- DONE


    @PostMapping("/workout")
    public ResponseEntity <Workout> addWorkout(@RequestBody Workout workout) {
        workout.generateId();
        Workout savedWorkout = repo.save(workout);
        return new ResponseEntity<>(savedWorkout, HttpStatus.CREATED);        
    }
    
    @GetMapping("/workouts")
    public List<Workout> getAllWorkouts(){
        return repo.findAll();
    }

    @GetMapping("/workout/{workoutID}")
    public ResponseEntity <Workout> getWorkout(@PathVariable String workoutID){
        Optional <Workout> workout = repo.findById(workoutID); // findById returns an Optional

        if (workout.isPresent()){
            return ResponseEntity.ok(workout.get());
        }
        else { 
            return ResponseEntity.notFound().build();
        }
    }

@PutMapping("workout/{workoutID}")
public ResponseEntity<Workout> updateWorkout(@PathVariable String workoutID, @RequestBody Workout workoutDetails) {
    Optional<Workout> optionalWorkout = repo.findById(workoutID);

    if (optionalWorkout.isPresent()) {
        Workout existingWorkout = optionalWorkout.get();

        if (workoutDetails.getWorkoutType() != null) {
            existingWorkout.setWorkoutType(workoutDetails.getWorkoutType());
        }

        if (workoutDetails.getDate() != null) {
            existingWorkout.setDate(workoutDetails.getDate());
        }

        Workout updatedWorkout = repo.save(existingWorkout);
        return new ResponseEntity<>(updatedWorkout, HttpStatus.OK);
    } else {
        return ResponseEntity.notFound().build();
    }
}

    @DeleteMapping("/workout/{workoutID}")
    public ResponseEntity <Workout> deleteWorkout(@PathVariable String workoutID){
        if (repo.existsById(workoutID)){
            repo.deleteById(workoutID);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } 
        else {
            return ResponseEntity.notFound().build();
        }




    }

}