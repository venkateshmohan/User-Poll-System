package com.company2.socialpolling;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PollEntityTests {
	Poll test_poll;
	@Before
	public void setUp() throws Exception {
		test_poll = new Poll();
		test_poll.setDescription("test_poll");
		test_poll.setCreatedAt(null);
		test_poll.setActive(true);
		test_poll.setCreatedBy("test_user");
        test_poll.setCreatedById(123);
	}

	@After
	public void tearDown() throws Exception {
		test_poll = null;
	}

	@Test
	public void testPoll() {
		assertNotNull(test_poll);
	}

	@Test
	public void testGetDescription() {
		assertEquals("test_poll", test_poll.getDescription());
	}

	@Test
	public void testSetDescription() {
		test_poll.setDescription("test_poll1");
		assertEquals("test_poll1", test_poll.getDescription());
	}

	@Test
	public void testGetCreatedAt() {
		assertNull(test_poll.getCreatedAt());
	}


	@Test
	public void testGetCreatedBy() {
		assertEquals("test_user", test_poll.getCreatedBy());
	}

	@Test
	public void testSetCreatedBy() {
		test_poll.setCreatedBy("test_user1");
		assertEquals("test_user1", test_poll.getCreatedBy());
	}

	@Test
	public void testGetCreatedById() {
		assertEquals(123, test_poll.getCreatedById());
	}

	@Test
	public void testSetCreatedById() {
		test_poll.setCreatedById(1234);;
		assertEquals(1234, test_poll.getCreatedById());
	}

	@Test
	public void testIsActive() {
		assertTrue(test_poll.isActive());
	}

	@Test
	public void testSetActive() {
		test_poll.setActive(false);
		assertFalse(test_poll.isActive());
	}

}




