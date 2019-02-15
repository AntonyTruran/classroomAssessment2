package com.qa.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.qa.classroomTests.ClassroomRepositoryTests;
import com.qa.traineeTests.TraineeRepositoryTests;

@RunWith(Suite.class)
@Suite.SuiteClasses({ClassroomRepositoryTests.class, TraineeRepositoryTests.class})
public class TestSuite {

}
