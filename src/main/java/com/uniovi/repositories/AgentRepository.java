package com.uniovi.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.uniovi.entities.Agent;

public interface AgentRepository extends MongoRepository<Agent, Long>{

}
