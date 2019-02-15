package com.qa.service;

public interface TraineeService {
	String getAllTrainees();

	String getATrainee(String trainee);

	int countByClassroom(int classroom);

	String addTrainee(String newTrainee);

	String removeTrainee(int id);

	String ammendTrainee(int id, String trainee);
}
