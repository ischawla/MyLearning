package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.ActorDAOInterface;
import com.example.model.Actor;

@RestController
@CrossOrigin
@RequestMapping("api/hello")
public class Budget {
	@Autowired
	ActorDAOInterface actor;

	
	/*
	 * @GetMapping public List<Actor> getAllActor() { return actor.findAll(); }
	 */
	
	@GetMapping
	public String getHello() {
		return "Hello";
	} 
}
