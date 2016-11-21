package com.ibm.javaee.sample.jaxrs;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ibm.javaee.sample.beans.SampleService;

@Path("sample")
public class SampleRestService {

	@Inject
	private SampleService service;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getDummy() {
		return service.getDummy();
	}
	
	@GET
    @Path("{name}")
	@Produces(MediaType.TEXT_PLAIN)
    public String getInfo(@PathParam("name") String payload) {
		return "At this date from service '" + service.getDate() + "' you typed: " + payload;
	}
	
	@POST
	@Path("value")
	@Consumes(MediaType.TEXT_PLAIN)
	public void setValue(String value) {
		service.setValue(value);
	}
	
	@GET
	@Path("value")
	@Produces(MediaType.TEXT_PLAIN)
	public String getValue() {
		return service.getValue();
	}

}
