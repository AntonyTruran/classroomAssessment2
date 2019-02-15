package com.qa.classroomTests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.qa.rest.ClassroomEndpoint;
import com.qa.service.ClassroomService;
import com.qa.util.JSONUtil;

public class ClassroomEndpointTests {
	@InjectMocks
	ClassroomEndpoint endpoint;
	@Mock
	ClassroomService service;
	
	private JSONUtil util;

	private static final String MOCK_OUTPUT = "tested success";
	private static final String MOCK_INPUT = "Test input";

	
	@Before
	public void setup() {
		util= new JSONUtil();
		endpoint.setService(service);
	}

	@Test
	public void getAllClassrooms() {
		Mockito.when(endpoint.getAllClassrooms()).thenReturn(MOCK_OUTPUT);
		assertEquals(MOCK_OUTPUT, endpoint.getAllClassrooms());
	}

	@Test
	public void getAClassroom() {
		Mockito.when(endpoint.getAClassroom(1234)).thenReturn(MOCK_OUTPUT);
		assertEquals(MOCK_OUTPUT, endpoint.getAClassroom(1234));
	}

	@Test
	public void addClassroom() {
		Mockito.when(endpoint.addClassroom(MOCK_INPUT)).thenReturn(MOCK_OUTPUT);
		assertEquals(MOCK_OUTPUT, endpoint.addClassroom(MOCK_INPUT));
	}

	@Test
	public void removeClassroom() {
		Mockito.when(endpoint.removeClassroom(1234)).thenReturn(MOCK_OUTPUT);
		assertEquals(MOCK_OUTPUT, endpoint.removeClassroom(1234));
	}

	@Test
	public void ammendClassroom() {
		Mockito.when(endpoint.ammendClassroom(1234, MOCK_INPUT)).thenReturn(MOCK_OUTPUT);
		assertEquals(MOCK_OUTPUT, endpoint.ammendClassroom(1234, MOCK_INPUT));
	}
}
