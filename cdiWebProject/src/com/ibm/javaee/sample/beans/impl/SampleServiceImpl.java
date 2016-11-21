package com.ibm.javaee.sample.beans.impl;

import java.util.Date;

import javax.enterprise.context.ApplicationScoped;

import com.ibm.javaee.sample.beans.SampleService;

@ApplicationScoped
public class SampleServiceImpl implements SampleService {
	
	private String value = "NOT SET";

	@Override
	public String getDummy() {
		return "Sample Service implementation, dummy method";
	}

	@Override
	public String getValue() {
		return value;
	}
	@Override
	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public Date getDate() {
		return new Date();
	}

}
