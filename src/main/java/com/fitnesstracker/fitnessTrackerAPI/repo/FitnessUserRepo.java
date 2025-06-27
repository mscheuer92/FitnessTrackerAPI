package com.fitnesstracker.fitnessTrackerAPI.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.fitnesstracker.fitnessTrackerAPI.model.FitnessUser;

@RepositoryRestResource
public interface FitnessUserRepo extends JpaRepository <FitnessUser, String> {

}
