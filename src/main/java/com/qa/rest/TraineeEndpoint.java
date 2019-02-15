package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.service.TraineeService;
import com.qa.util.JSONUtil;

@Path("/trainee")
public class TraineeEndpoint {
	@Inject
	private TraineeService service;
	@Inject
	private JSONUtil util;

	@Path("/countByClassroom")
	@GET
	@Produces({ "applicaiton/json" })
	public String getAllTrainees() {
		return service.getAllTrainees();
	}

	@Path("/getATrainee")
	@GET
	@Produces({ "applicaiton/json" })
	public String getATrainee(String trainee) {
		return service.getATrainee(trainee);
	}

	@Path("/countByClassroom")
	@GET
	@Produces({ "applicaiton/json" })
	public int countByClassroom(@PathParam("assignedClassroom") int classroom) {
		return service.countByClassroom(classroom);
	}

	@Path("/addTrainee")
	@POST
	@Produces({ "applicaiton/json" })
	public String addTrainee(String newTrainee) {
		return service.addTrainee(newTrainee);
	}

	@Path("/removeTrainee")
	@DELETE
	@Produces({ "applicaiton/json" })
	public String removeTrainee(@PathParam("Id") int id) {
		return service.removeTrainee(id);
	}

	@Path("/ammendTrainee")
	@PUT
	@Produces({ "applicaiton/json" })
	public String ammendTrainee(@PathParam("Id") int id, String trainee) {
		return service.ammendTrainee(id, trainee);
	}

	public void setService(TraineeService service) {
		this.service = service;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}
}
