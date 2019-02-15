package com.qa.service;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.qa.persistence.repository.TraineeRepository;
import com.qa.util.JSONUtil;


@Default
@Transactional(SUPPORTS)
public class TraineeServiceImpl implements TraineeService{

	@Inject
	TraineeRepository repo;
	@Inject
	private JSONUtil util;
	@Override
	public String getAllTrainees() {
		return repo.getAllTrainees();
	}

	@Override
	public String getATrainee(String trainee) {
		return repo.getATrainee(trainee);
	}

	@Override
	public int countByClassroom(int classroom) {
		return repo.countByClassroom(classroom);
	}

	@Transactional(REQUIRED)
	@Override
	public String addTrainee(String newTrainee) {
		return repo.addTrainee(newTrainee);
	}

	@Transactional(REQUIRED)
	@Override
	public String removeTrainee(int id) {
		return repo.removeTrainee(id);
	}

	@Transactional(REQUIRED)
	@Override
	public String ammendTrainee(int id, String trainee) {
		return repo.ammendTrainee(id, trainee);
	}

	public void setRepo(TraineeRepository repo) {
		this.repo = repo;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

}
