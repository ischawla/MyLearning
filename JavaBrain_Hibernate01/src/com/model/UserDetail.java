package com.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@NamedQuery(name = "UsersById",query="from UserDetail where userId > :lim")
@NamedNativeQuery(name = "UsersByName",query = "select * from USER_DETAILS where userName = :uname",resultClass = UserDetail.class)
@Table(name="USER_DETAILS")
public class UserDetail {

@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)
private int userId;
private String userName;

@OneToMany(cascade = CascadeType.PERSIST)
private List<Vehicle> vehicleList = new ArrayList<Vehicle>(); 



public List<Vehicle> getVehicleList() {
	return vehicleList;
}
public void setVehicleList(List<Vehicle> vehicleList) {
	this.vehicleList = vehicleList;
}
@Temporal(TemporalType.DATE)
private Date joinDate;
private String description;
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}

public Date getJoinDate() {
	return joinDate;
}
public void setJoinDate(Date joinDate) {
	this.joinDate = joinDate;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}

}
