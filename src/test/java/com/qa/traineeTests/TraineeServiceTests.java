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
import com.qa.persistence.repository.TraineeRepository;
import com.qa.service.TraineeServiceImpl;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class TraineeServiceTests {
	@InjectMocks
	TraineeServiceImpl service;
	@Mock
	TraineeRepository repo;
	private JSONUtil util;

	private static final String MOCK_OUTPUT = "tested success";
	private static final String MOCK_INPUT = "Test input";

	@Before
	public void setup() {
		util = new JSONUtil();
		service.setRepo(repo);
	}

	@Test
	public void getAllTrainees() {
		Mockito.when(service.getAllTrainees()).thenReturn(MOCK_OUTPUT);
		assertEquals(MOCK_OUTPUT,service.getAllTrainees());
	}

	@Test
	public void getATrainee() {
		Mockito.when(service.getATrainee(MOCK_INPUT)).thenReturn(MOCK_OUTPUT);
		assertEquals(MOCK_OUTPUT,service.getATrainee(MOCK_INPUT));
	}

	@Test
	public void countByClassroom() {
		Mockito.when(service.countByClassroom(1234)).thenReturn(4321);
		assertEquals(4321,service.countByClassroom(1234));
	}

	@Test
	public void addTrainee() {
		Mockito.when(service.addTrainee(MOCK_INPUT)).thenReturn(MOCK_OUTPUT);
		assertEquals(MOCK_OUTPUT,service.addTrainee(MOCK_INPUT));
	}

	@Test
	public void removeTrainee() {
		Mockito.when(service.removeTrainee(1234)).thenReturn(MOCK_OUTPUT);
		assertEquals(MOCK_OUTPUT,service.removeTrainee(1234));
	}

	@Test
	public void ammendTrainee() {
		Mockito.when(service.ammendTrainee(1234,MOCK_INPUT)).thenReturn(MOCK_OUTPUT);
		assertEquals(MOCK_OUTPUT,service.ammendTrainee(1234,MOCK_INPUT));
	}
}
