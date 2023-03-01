package com.example.DSS_project.Repository;

import com.example.DSS_project.model.Skier;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkierRepository extends MongoRepository<Skier, String>{


}
