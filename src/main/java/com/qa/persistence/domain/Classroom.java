package com.qa.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Classroom {

	public Classroom() {
	}

	public Classroom(String trainerName) {
		this.trainerName = trainerName;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int classroomID;
	@Column(length = 100)
	private String trainerName;

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}
}
