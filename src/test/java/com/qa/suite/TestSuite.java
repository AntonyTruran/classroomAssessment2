package com.qa.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.qa.classroomTests.ClassroomRepositoryTests;
import com.qa.classroomTests.ClassroomServiceTests;
import com.qa.traineeTests.TraineeRepositoryTests;
import com.qa.traineeTests.TraineeServiceTests;

@RunWith(Suite.class)
@Suite.SuiteClasses({ TraineeRepositoryTests.class,ClassroomRepositoryTests.class,TraineeServiceTests.class,ClassroomServiceTests.class})
public class TestSuite {

}
