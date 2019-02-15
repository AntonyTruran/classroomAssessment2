package com.qa.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.qa.classroomTests.ClassroomRepositoryTests;
import com.qa.traineeTests.TraineeRepositoryTests;

@RunWith(Suite.class)
@Suite.SuiteClasses({ TraineeRepositoryTests.class,ClassroomRepositoryTests.class})
public class TestSuite {

}
