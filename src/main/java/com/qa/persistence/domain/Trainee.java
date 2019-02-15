package com.qa.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Trainee {

	public Trainee() {
	}

	public Trainee(String traineeName, int assignedClassroom) {
		super();
		this.traineeName = traineeName;
		this.assignedClassroom = assignedClassroom;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(length = 100)
	private String traineeName;
	@OneToMany
	@Column(length = 2)
	private int assignedClassroom;

	public String getTraineeName() {
		return traineeName;
	}

	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}

	public int getAssignedClassroom() {
		return assignedClassroom;
	}

	public void setAssignedClassroom(int assignedClassroom) {
		this.assignedClassroom = assignedClassroom;
	}

	public int getId() {
		return id;
	}
}
