package com.myshop.base;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.myshop.dto.SampleDTO;

public class LombokTest {
	private final static Logger logger = LoggerFactory.getLogger(LombokTest.class);
	
	@Test
	public void testLombok() {
		SampleDTO sample = new SampleDTO();
		sample.setField1("샘플1");
		sample.setField2(3.14);
		sample.setField3(999);
		logger.info(sample.toString());
	}
}