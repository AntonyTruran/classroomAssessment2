package com.qa.traineeTests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.persistence.domain.Trainee;
import com.qa.persistence.repository.TraineeDBRepository;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class TraineeRepositoryTests {
	@InjectMocks
	TraineeDBRepository repo;
	@Mock
	private EntityManager entity;
	@Mock
	private Query query;

	private JSONUtil util;

	private static final String MOCK_TABLE_ROW = "[{\"id\":0,\"traineeName\":\"David Bloggs\",\"assignedClassroom\":2}]";
	private static final String MOCK_ENTRY = "{\"id\":0,\"traineeName\":\"David Bloggs\",\"assignedClassroom\":2}";

	@Before
	public void setup() {
		repo.setEntity(entity);
		util = new JSONUtil();
		repo.setUtil(util);
	}

	@Test
	public void getAllTrainees() {
		Mockito.when(entity.createQuery(Mockito.anyString())).thenReturn(query);
		List<Trainee> mockTrainee = new ArrayList<Trainee>();
		mockTrainee.add(new Trainee("David Bloggs", 2));
		Mockito.when(query.getResultList()).thenReturn(mockTrainee);
		assertEquals(MOCK_TABLE_ROW, repo.getAllTrainees());
	}

	@Test
	public void getATrainee() {
		Trainee mockTrainee = new Trainee("David Bloggs", 2);
		Mockito.when(entity.find(Mockito.anyObject(), Mockito.anyLong())).thenReturn(mockTrainee);
		assertEquals(MOCK_ENTRY, repo.getATrainee("David Bloggs"));
	}

	@Test
	public void countByClassroom() {
		Mockito.when(entity.createQuery(Mockito.anyString())).thenReturn(query);
		List<Trainee> cycledTrainees = new ArrayList<Trainee>();
		cycledTrainees.add(new Trainee("David Bloggs", 2));
		Mockito.when(query.getResultList()).thenReturn(cycledTrainees);
		assertEquals(1, repo.countByClassroom(2));
	}

	@Test
	public void addTrainee() {
		assertEquals("{\"message\":\"The trainee has been successfully added\"}", repo.addTrainee(MOCK_ENTRY));
	}

	@Test
	public void removeTraineeValid() {
		Mockito.when(entity.contains(Mockito.anyObject())).thenReturn(true);
		assertEquals("{\"message\":\"Trainee successfully removed\"}", repo.removeTrainee(1));
	}

	@Test
	public void removeTraineeInvalid() {
		assertEquals("{\"message\":\"No such trainee\"}", repo.removeTrainee(1));
	}

	@Test
	public void ammendTraineeInvalid() {
		String trainee = "{\"traineeId\":\"1\",\"traineeName\":\"Dave Bloggs\",\"assignedClassroom\":\"2\"}";
		assertEquals("{\"message\": \"no such trainee\"}", repo.ammendTrainee(1, trainee));
	}

	@Test
	public void ammendTraineeValid1() {
		String trainee = "{\"id\":\"1\"}";
		Mockito.when(entity.contains(Mockito.anyObject())).thenReturn(true);
		Mockito.when(entity.find(Mockito.any(), Mockito.anyLong())).thenReturn(trainee);
		assertEquals("{\"message\": \"trainee has been sucessfully updated\"}", repo.ammendTrainee(1, trainee));
	}

	@Test
	public void ammendTraineeValid2() {
		String trainee = "{\"traineeName\":\"Dave Bloggs\",\"assignedClassroom\":\"1\"}";
		Mockito.when(entity.contains(Mockito.anyObject())).thenReturn(true);
		Mockito.when(entity.find(Mockito.any(), Mockito.anyLong())).thenReturn(trainee);
		assertEquals("{\"message\": \"trainee has been sucessfully updated\"}", repo.ammendTrainee(1, trainee));
	}

}
