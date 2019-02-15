package com.qa.service;

public interface ClassroomService {
	String getAllClassrooms();

	String getAClassroom(int classroomId);

	String addClassroom(String newClassroom);

	String removeClassroom(int id);

	String ammendClassroom(int id, String classroom);

}
