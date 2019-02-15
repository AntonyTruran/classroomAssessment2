package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Classroom;
import com.qa.persistence.domain.Trainee;
import com.qa.util.JSONUtil;

@Default
@Transactional(SUPPORTS)
public class ClassroomDBRepository implements ClassroomRepository {
	@PersistenceContext(unitName = "primary")
	private EntityManager entity;
	@Inject
	private JSONUtil util;
	@Override
	public String getAllClassrooms() {
		Query query = entity.createQuery("SELECT a FROM Classroom c");
		return util.getJSONForObject(query.getResultList());
	}

	@Override
	public String getAClassroom(int classroomId) {
		return util.getJSONForObject(entity.find(Classroom.class, classroomId));
	}

	@Transactional(REQUIRED)
	@Override
	public String addClassroom(String newClassroom) {
		Trainee aTrainee = util.getObjectForJSON(newClassroom, Trainee.class);
		entity.persist(aTrainee);
		return "{\"message\":\"The classroom has been successfully added\"}";
	}

	@Transactional(REQUIRED)
	@Override
	public String removeClassroom(int id) {
		if (entity.contains(entity.find(Classroom.class, id))) {
			entity.remove(entity.find(Classroom.class, id));
			return "{\"message\":\"Classroom successfully removed\"}";
		}
		return "{\"message\":\"No such classroom\"}";
	}

	@Override
	public String ammendClassroom(int id, String classroom) {
		Trainee aClassroom = util.getObjectForJSON(classroom, Trainee.class);
		if (entity.contains(entity.find(Trainee.class, id))) {
			entity.merge(aClassroom);
			return "{\"message\": \"classroom has been sucessfully updated\"}";
		}
		return "{\"message\": \"no such classroom\"}";
	}

	public void setEntity(EntityManager entity) {
		this.entity = entity;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

}
