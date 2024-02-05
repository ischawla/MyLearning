package com.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
public class TwoWheeler extends Vehicle {
private String stearinghandle;

public String getStearinghandle() {
	return stearinghandle;
}

public void setStearinghandle(String stearinghandle) {
	this.stearinghandle = stearinghandle;
}}
