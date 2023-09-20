package com.adan.Microservices.repository;

import com.adan.Microservices.model.Microservice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MicroserviceRepository extends JpaRepository<Microservice, Integer> {
}
