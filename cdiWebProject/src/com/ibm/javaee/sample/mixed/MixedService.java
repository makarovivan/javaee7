package com.ibm.javaee.sample.mixed;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ibm.javaee.sample.beans.SampleService;

@WebService(name="MyWebService", serviceName="mixed")
@Path("mixed")
public class MixedService {

	@Inject
	private SampleService service;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@WebMethod
	public String getDefault() {
		return "Hi from mixed service method!";
	}

	@GET
    @Path("{name}")
	@Produces(MediaType.TEXT_PLAIN)
	@WebMethod
    public String getInfo(@WebParam(name="name") @PathParam("name") String payload) {
		return "At this date from service '" + service.getDate() + "' you typed: " + payload;
	}
	
	
	@POST
	@Path("value")
	@Consumes(MediaType.TEXT_PLAIN)
	@WebMethod
	public void setValue(@WebParam(name="value") String value) {
		service.setValue(value);
	}
	
	@GET
	@Path("value")
	@Produces(MediaType.TEXT_PLAIN)
	@WebMethod
	public String getValue() {
		return service.getValue();
	}

}
