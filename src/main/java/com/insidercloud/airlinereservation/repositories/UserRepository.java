package com.insidercloud.airlinereservation.repositories;

import com.insidercloud.airlinereservation.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
}
