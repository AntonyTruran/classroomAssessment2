package com.qa.classroomTests;

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

import com.qa.persistence.domain.Classroom;
import com.qa.persistence.repository.ClassroomDBRepository;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class ClassroomRepositoryTests {
	@InjectMocks
	ClassroomDBRepository repo;
	@Mock
	private EntityManager entity;
	@Mock
	private Query query;

	private JSONUtil util;

	private static final String MOCK_TABLE_ROW = "[{\"classroomId\":0,\"trainerName\":\"John Gordon\"}]";
	private static final String MOCK_ENTRY = "{\"classroomId\":0,\"trainerName\":\"John Gordon\"}";

	@Before
	public void setup() {
		repo.setEntity(entity);
		util = new JSONUtil();
		repo.setUtil(util);
	}

	@Test
	public void getAllClassrooms() {
		Mockito.when(entity.createQuery(Mockito.anyString())).thenReturn(query);
		List<Classroom> mockClassroom = new ArrayList<Classroom>();
		mockClassroom.add(new Classroom("John Gordon"));
		Mockito.when(query.getResultList()).thenReturn(mockClassroom);
		assertEquals(MOCK_TABLE_ROW, repo.getAllClassrooms());
	}

	@Test
	public void getAClassroom() {
		Classroom mockClassroom = new Classroom("John Gordon");
		Mockito.when(entity.find(Mockito.anyObject(), Mockito.anyLong())).thenReturn(mockClassroom);
		assertEquals(MOCK_ENTRY, repo.getAClassroom(1));
	}

	@Test
	public void addClassroom() {
		assertEquals("{\"message\":\"The classroom has been successfully added\"}", repo.addClassroom(MOCK_ENTRY));
	}

	@Test
	public void removeClassroomValid() {
		Mockito.when(entity.contains(Mockito.anyObject())).thenReturn(true);
		assertEquals("{\"message\":\"Classroom successfully removed\"}", repo.removeClassroom(1));
	}

	@Test
	public void removeClassroomInvalid() {
		assertEquals("{\"message\":\"No such classroom\"}", repo.removeClassroom(1));
	}

	@Test
	public void ammendClassroomInvalid() {
		String classroom = "{\"trainerId\":\"1\",\"classroomName\":\"John Gordon\",\"assignedClassroom\":\"1\"}";
		assertEquals("{\"message\": \"no such classroom\"}", repo.ammendClassroom(1, classroom));
	}

	@Test
	public void ammendClassroomValid1() {
		String classroom = "{\"classroomId\":\"1\"}";
		Mockito.when(entity.contains(Mockito.anyObject())).thenReturn(true);
		Mockito.when(entity.find(Mockito.any(), Mockito.anyLong())).thenReturn(classroom);
		assertEquals("{\"message\": \"classroom has been sucessfully updated\"}", repo.ammendClassroom(1, classroom));
	}

	@Test
	public void ammendClassroomValid2() {
		String classroom = "{\"trainerName\":\"Dave Bloggs\",\"assignedClassroom\":\"1\"}";
		Mockito.when(entity.contains(Mockito.anyObject())).thenReturn(true);
		Mockito.when(entity.find(Mockito.any(), Mockito.anyLong())).thenReturn(classroom);
		assertEquals("{\"message\": \"classroom has been sucessfully updated\"}", repo.ammendClassroom(1, classroom));
	}

}