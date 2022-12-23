package com.insidercloud.airlinereservation.repositories;

import com.insidercloud.airlinereservation.models.Plane;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaneRepository extends MongoRepository<Plane,String> {
}
