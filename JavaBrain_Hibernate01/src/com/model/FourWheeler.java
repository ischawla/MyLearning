package com.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
public class FourWheeler extends Vehicle {
private String stearingwheel;

public String getStearingwheel() {
	return stearingwheel;
}

public void setStearingwheel(String stearingwheel) {
	this.stearingwheel = stearingwheel;
}}
