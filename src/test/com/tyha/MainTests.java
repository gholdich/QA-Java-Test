package com.tyha;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.tyha.core.BoatManagerTests;
import com.tyha.core.FileManagerTests;
import com.tyha.core.MarinaManagerTests;
import com.tyha.core.PersonManagerTests;
import com.tyha.handlers.LogicHandlerTests;
import com.tyha.objects.BoatTests;
import com.tyha.objects.BoatTests.BoatParamTests;
import com.tyha.objects.EntitysTests;
import com.tyha.objects.MarinaTests;
import com.tyha.objects.PersonTests;

@RunWith(Suite.class)
@SuiteClasses({
				LogicHandlerTests.class,
				MarinaManagerTests.class,
				BoatManagerTests.class,
				PersonManagerTests.class,
				FileManagerTests.class,
				BoatTests.class, 
				BoatParamTests.class,
				MarinaTests.class,
				PersonTests.class,
				EntitysTests.class
				})
public class MainTests {
	
	
}
