package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.service.ClassroomService;
import com.qa.util.JSONUtil;

@Path("/classroom")
public class ClassroomEndpoint {
	
	@Inject
	private ClassroomService service;
	@Inject
	private JSONUtil util;

	@Path("/getAllClassrooms")
	@GET
	@Produces({ "applicaiton/json" })
	public String getAllClassrooms() {
		return service.getAllClassrooms();
	}

	@Path("/getAClassroom")
	@GET
	@Produces({ "applicaiton/json" })
	public String getAClassroom(@PathParam("classroomId") int classroomId) {
		return service.getAClassroom(classroomId);
	}

	@Path("/addClassroom")
	@POST
	@Produces({ "applicaiton/json" })
	public String addClassroom(String newClassroom) {
		return service.addClassroom(newClassroom);
	}

	@Path("/removeClassroom")
	@DELETE
	@Produces({ "applicaiton/json" })
	public String removeClassroom(@PathParam("classroomId") int id) {
		return service.removeClassroom(id);
	}

	@Path("/ammendClassroom")
	@PUT
	@Produces({ "applicaiton/json" })
	public String ammendClassroom(@PathParam("classroomId") int id, String classroom) {
		return service.ammendClassroom(id, classroom);
	}

	public void setService(ClassroomService service) {
		this.service = service;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}
	

}
