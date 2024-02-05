package com.example.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.model.Actor;
public interface ActorDAOInterface extends JpaRepository<Actor, Integer>{

	
}
