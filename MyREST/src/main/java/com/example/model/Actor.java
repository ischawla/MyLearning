package com.example.model;

import javax.persistence.Entity;

@Entity(name = "actor")
public class Actor {
private int actor_id;
private String first_name;
private String last_name;

public Actor() {
	
}

public Actor(int actor_id, String first_name, String last_name) {
	super();
	this.actor_id = actor_id;
	this.first_name = first_name;
	this.last_name = last_name;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + actor_id;
	result = prime * result + ((first_name == null) ? 0 : first_name.hashCode());
	result = prime * result + ((last_name == null) ? 0 : last_name.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Actor other = (Actor) obj;
	if (actor_id != other.actor_id)
		return false;
	if (first_name == null) {
		if (other.first_name != null)
			return false;
	} else if (!first_name.equals(other.first_name))
		return false;
	if (last_name == null) {
		if (other.last_name != null)
			return false;
	} else if (!last_name.equals(other.last_name))
		return false;
	return true;
}

@Override
public String toString() {
	return "Actor [actor_id=" + actor_id + ", first_name=" + first_name + ", last_name=" + last_name
			+ ", getActor_id()=" + getActor_id() + ", getFirst_name()=" + getFirst_name() + ", getLast_name()="
			+ getLast_name() + "]";
}


public int getActor_id() {
	return actor_id;
}
public void setActor_id(int actor_id) {
	this.actor_id = actor_id;
}
public String getFirst_name() {
	return first_name;
}
public void setFirst_name(String first_name) {
	this.first_name = first_name;
}
public String getLast_name() {
	return last_name;
}
public void setLast_name(String last_name) {
	this.last_name = last_name;
}


}
