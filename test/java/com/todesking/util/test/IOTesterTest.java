package com.todesking.util.test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

public class IOTesterTest {
	private IOTester target;

	@Before
	public void before() {
		target = new IOTester();
	}

	@Test
	public void lines() throws Exception {
		target.lines("1", "2");
		assertThat(target.in().readLine(), is("1"));
		assertThat(target.in().readLine(), is("2"));
		assertNull(target.in().readLine());
	}

	@Test
	public void assertOutLines() throws Exception {
		final PrintStream out = target.out();
		out.println("line 1");
		out.println("line 2");

		// assertion success
		target.assertOutLines("line 1", "line 2");

		try {
			target.assertOutLines("line 1", "line 100");
			fail("Illegal out value is ignored");
		} catch (AssertionError e) {
			// ok
		}

		try {
			target.assertOutLines("line 1");
			fail(" line count is ignored.");
		} catch (AssertionError e) {
			// ok
		}
	}
}
