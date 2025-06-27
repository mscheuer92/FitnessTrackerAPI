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

import com.fitnesstracker.fitnessTrackerAPI.model.FitnessUser;
import com.fitnesstracker.fitnessTrackerAPI.repo.FitnessUserRepo;


// POST /user - create user -- DONE
// GET List<User> - list all users
// PUT /user/{id} -- Update username
// DELETE /user/{id} -- delete user


@RestController
public class FitnessUserController {

@Autowired
FitnessUserRepo userRepo;

@PostMapping("/user")
public ResponseEntity<FitnessUser> addUser(@RequestBody FitnessUser user)
{
    FitnessUser newUser = userRepo.save(user);
    return new ResponseEntity<>(newUser, HttpStatus.CREATED);
}

@GetMapping("/users")
public List<FitnessUser> getAllUsers() {
    return userRepo.findAll();
}


@PutMapping("/user/{userID}")
public ResponseEntity<FitnessUser> updateUser(@PathVariable String userID, @RequestBody FitnessUser user) {
    Optional <FitnessUser> updateUser = userRepo.findById(userID);
    if(updateUser.isPresent()){
        FitnessUser existingUser = updateUser.get();
        existingUser.setUsername(user.getUsername());
        
        FitnessUser updatedUser = userRepo.save(existingUser);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
    else{
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

@DeleteMapping("/user/{userID}")
public ResponseEntity<FitnessUser> deleteUser(@PathVariable String userID){
    Optional<FitnessUser> deleteUser = userRepo.findById(userID);
    if (deleteUser.isPresent()){
        userRepo.deleteById(userID);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}

}
