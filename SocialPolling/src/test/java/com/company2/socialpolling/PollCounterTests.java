package com.company2.socialpolling;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PollCounterTests {
	PollCounter test_pollCounter;
	@Before
	public void setUp() throws Exception {
		test_pollCounter = new PollCounter();
        test_pollCounter.setPollId(1);
        test_pollCounter.setOptionValue(2);
        test_pollCounter.setCounter(1);
	}

	@After
	public void tearDown() throws Exception {
		test_pollCounter = null;
	}

	@Test
	public void testGetPollId() {
		assertEquals(1, test_pollCounter.getPollId());
	}

	@Test
	public void testGetOptionValue() {
		assertEquals(2, test_pollCounter.getOptionValue());
	}
	
	@Test
	public void testGetCounter() {
		assertEquals(1, test_pollCounter.getCounter());
	}


	




}


