package com.todesking.util.test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.google.common.collect.Lists;

public class IOTester {

	private List<String> lines = Lists.newArrayList();
	private ByteArrayOutputStream out = new ByteArrayOutputStream();

	public void lines(String... lines) {
		this.lines.addAll(Arrays.asList(lines));
	}

	private BufferedReader in = null;

	public BufferedReader in() {
		if (in == null)
			in =
				new BufferedReader(new InputStreamReader(
					new ByteArrayInputStream(StringUtils
						.join(lines, '\n')
						.getBytes())));
		return in;
	}

	public PrintStream out() {
		return new PrintStream(out);
	}

	public void assertOutLines(String... expectedLines) {
		final String[] actualLines =
			new String(out.toByteArray()).split("\r[\n]?");
		assertThat(actualLines.length, is(expectedLines.length));
		for (int i = 0; i < expectedLines.length; i++) {
			assertThat(
				"line " + i + "(0 origin) has not expected value",
				actualLines[i],
				is(expectedLines[i]));
		}
	}
}