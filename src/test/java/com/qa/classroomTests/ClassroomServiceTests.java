package com.qa.classroomTests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.persistence.domain.Classroom;
import com.qa.persistence.repository.ClassroomRepository;
import com.qa.service.ClassroomServiceImpl;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class ClassroomServiceTests {
	@InjectMocks
	ClassroomServiceImpl service;
	@Mock
	ClassroomRepository repo;
	private JSONUtil util;

	private static final String MOCK_OUTPUT = "tested success";
	private static final String MOCK_INPUT = "Test input";

	@Before
	public void setup() {
		util = new JSONUtil();
		service.setRepo(repo);
	}

	@Test
	public void getAllClassrooms() {
		Mockito.when(service.getAllClassrooms()).thenReturn(MOCK_OUTPUT);
		assertEquals(MOCK_OUTPUT, service.getAllClassrooms());
	}

	@Test
	public void getAClassroom() {
		Mockito.when(service.getAClassroom(1234)).thenReturn(MOCK_OUTPUT);
		assertEquals(MOCK_OUTPUT, service.getAClassroom(1234));
	}

	@Test
	public void addClassroom() {
		Mockito.when(service.addClassroom(MOCK_INPUT)).thenReturn(MOCK_OUTPUT);
		assertEquals(MOCK_OUTPUT, service.addClassroom(MOCK_INPUT));
	}

	@Test
	public void removeClassroom() {
		Mockito.when(service.removeClassroom(1234)).thenReturn(MOCK_OUTPUT);
		assertEquals(MOCK_OUTPUT, service.removeClassroom(1234));
	}

	@Test
	public void ammendClassroom() {
		Mockito.when(service.ammendClassroom(1234, MOCK_INPUT)).thenReturn(MOCK_OUTPUT);
		assertEquals(MOCK_OUTPUT,service.ammendClassroom(1234, MOCK_INPUT));
	}

}
