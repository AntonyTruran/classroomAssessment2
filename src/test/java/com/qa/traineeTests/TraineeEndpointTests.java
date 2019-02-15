package com.qa.traineeTests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.rest.TraineeEndpoint;
import com.qa.service.TraineeService;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class TraineeEndpointTests {
	@InjectMocks
	TraineeEndpoint endpoint;
	@Mock
	TraineeService service;
	private JSONUtil util;

	private static final String MOCK_OUTPUT = "tested success";
	private static final String MOCK_INPUT = "Test input";
	
	@Before
	public void setup() {
		util = new JSONUtil();
		endpoint.setService(service);
	}

	@Test
	public void getAllTrainees() {
		Mockito.when(endpoint.getAllTrainees()).thenReturn(MOCK_OUTPUT);
		assertEquals(MOCK_OUTPUT,endpoint.getAllTrainees());
	}

	@Test
	public void getATrainee() {
		Mockito.when(endpoint.getATrainee(MOCK_INPUT)).thenReturn(MOCK_OUTPUT);
		assertEquals(MOCK_OUTPUT,endpoint.getATrainee(MOCK_INPUT));
	}

	@Test
	public void countByClassroom() {
		Mockito.when(endpoint.countByClassroom(1234)).thenReturn(4321);
		assertEquals(4321,endpoint.countByClassroom(1234));
	}

	@Test
	public void addTrainee() {
		Mockito.when(endpoint.addTrainee(MOCK_INPUT)).thenReturn(MOCK_OUTPUT);
		assertEquals(MOCK_OUTPUT,endpoint.addTrainee(MOCK_INPUT));
	}

	@Test
	public void removeTrainee() {
		Mockito.when(endpoint.removeTrainee(1234)).thenReturn(MOCK_OUTPUT);
		assertEquals(MOCK_OUTPUT,endpoint.removeTrainee(1234));
	}

	@Test
	public void ammendTrainee() {
		Mockito.when(endpoint.ammendTrainee(1234,MOCK_INPUT)).thenReturn(MOCK_OUTPUT);
		assertEquals(MOCK_OUTPUT,endpoint.ammendTrainee(1234,MOCK_INPUT));
	}
}
