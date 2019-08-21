package com.company2.socialpolling;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PollOptionEntityTest {
	PollOptions test_poll_option;
	@Before
	public void setUp() throws Exception {
		test_poll_option = new PollOptions();
		test_poll_option.setOptionDesc("test_poll_option");
		test_poll_option.setOptionValue(1);
		test_poll_option.setPoll(1);
	}

	@After
	public void tearDown() throws Exception {
		test_poll_option = null;
	}

	@Test
	public void testPollOptions() {
		assertNotNull(test_poll_option);
	}

	@Test
	public void testGetDescription() {
		assertEquals("test_poll_option", test_poll_option.getOptionDesc());
	}

	@Test
	public void testSetDescription() {
		test_poll_option.setOptionDesc("test_poll_option1");;
		assertEquals("test_poll_option1", test_poll_option.getOptionDesc());
	}
	
	@Test
	public void testGetOptionValue() {
		assertEquals(1, test_poll_option.getOptionValue());
	} 
	
	@Test
	public void testSetOptionValue() {
		test_poll_option.setOptionValue(2);
		assertEquals(2, test_poll_option.getOptionValue());
	}

//	@Test
//	public void testGetCreatedBy() {
//		assertEquals("test_user", test_poll.getCreatedBy());
//	}
//
//	@Test
//	public void testSetCreatedBy() {
//		test_poll.setCreatedBy("test_user1");
//		assertEquals("test_user1", test_poll.getCreatedBy());
//	}
//
//	@Test
//	public void testGetCreatedById() {
//		assertEquals(123, test_poll.getCreatedById());
//	}
//
//	@Test
//	public void testSetCreatedById() {
//		test_poll.setCreatedById(1234);;
//		assertEquals(1234, test_poll.getCreatedById());
//	}

//	@Test
//	public void testIsActive() {
//		assertTrue(test_poll.isActive());
//	}
//
//	@Test
//	public void testSetActive() {
//		test_poll.setActive(false);
//		assertFalse(test_poll.isActive());
//	}

}




