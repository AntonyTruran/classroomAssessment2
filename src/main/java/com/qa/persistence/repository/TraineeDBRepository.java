package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Trainee;
import com.qa.util.JSONUtil;

@Default
@Transactional(SUPPORTS)
public class TraineeDBRepository implements TraineeRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager entity;
	@Inject
	private JSONUtil util;

	@Override
	public String getAllTrainees() {
		Query query = entity.createQuery("SELECT a FROM Trainee t");
		return util.getJSONForObject(query.getResultList());
	}

	@Override
	public String getATrainee(String trainee) {
		return util.getJSONForObject(entity.find(Trainee.class, trainee));
	}

	@Override
	public int countByClassroom(int classroom) {
		Query query = entity.createQuery("SELECT a FROM Trainee a");
		return ((Collection<Trainee>) query.getResultList()).stream()
				.filter(n -> n.getAssignedClassroom() == (classroom)).collect(Collectors.toList()).size();
	}

	@Transactional(REQUIRED)
	@Override
	public String addTrainee(String newTrainee) {
		Trainee aTrainee = util.getObjectForJSON(newTrainee, Trainee.class);
		entity.persist(aTrainee);
		return "{\"message\":\"The trainee has been successfully added\"}";
	}

	@Transactional(REQUIRED)
	@Override
	public String removeTrainee(int id) {
		if (entity.contains(entity.find(Trainee.class, id))) {
			entity.remove(entity.find(Trainee.class, id));
			return "{\"message\":\"Trainee successfully removed\"}";
		}
		return "{\"message\":\"No such trainee\"}";
	}

	@Transactional(REQUIRED)
	@Override
	public String ammendTrainee(int id, String trainee) {
		Trainee aTrainee = util.getObjectForJSON(trainee, Trainee.class);
		if (entity.contains(entity.find(Trainee.class, id))) {
			entity.merge(aTrainee);
			return "{\"message\": \"trainee has been sucessfully updated\"}";
		}
		return "{\"message\": \"no such trainee\"}";
	}

	public void setEntity(EntityManager entity) {
		this.entity = entity;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

}
