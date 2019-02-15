package com.qa.service;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.qa.persistence.repository.ClassroomRepository;
import com.qa.persistence.repository.TraineeRepository;
import com.qa.util.JSONUtil;

@Default
@Transactional(SUPPORTS)
public class ClassroomServiceImpl implements ClassroomService{
	@Inject
	ClassroomRepository repo;
	@Inject
	private JSONUtil util;
	@Override
	public String getAllClassrooms() {
		// TODO Auto-generated method stub
		return repo.getAllClassrooms();
	}

	@Override
	public String getAClassroom(int classroomId) {
		// TODO Auto-generated method stub
		return repo.getAClassroom(classroomId);
	}

	@Transactional(REQUIRED)
	@Override
	public String addClassroom(String newClassroom) {
		// TODO Auto-generated method stub
		return repo.addClassroom(newClassroom);
	}

	@Transactional(REQUIRED)
	@Override
	public String removeClassroom(int id) {
		// TODO Auto-generated method stub
		return repo.removeClassroom(id);
	}

	@Transactional(REQUIRED)
	@Override
	public String ammendClassroom(int id, String classroom) {
		// TODO Auto-generated method stub
		return repo.ammendClassroom(id, classroom);
	}
	
	public void setRepo(ClassroomRepository repo) {
		this.repo = repo;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

}
