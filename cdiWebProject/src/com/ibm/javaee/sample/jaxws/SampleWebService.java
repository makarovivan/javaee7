package com.ibm.javaee.sample.jaxws;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.ibm.javaee.sample.beans.SampleService;

@WebService(name="SampleWebService", serviceName="jaxws")
public class SampleWebService {

	@Inject
	private SampleService service;
	
	@WebMethod
	public String getDummy() {
		return service.getDummy();
	}
	
    public String getInfo(@WebParam(name="name") String payload) {
		return "At this date from service '" + service.getDate() + "' you typed: " + payload;
	}
	
	public void setValue(@WebParam(name="value") String value) {
		service.setValue(value);
	}
	
	public String getValue() {
		return service.getValue();
	}

}
