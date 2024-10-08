package com.example.controller;

import com.example.model.Student;
import com.example.service.StudentService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/students")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StudentController {

    @Inject
    private StudentService studentService;

    @GET
    public Response getStudents() {
        List<Student> students = studentService.getStudents();
        return Response.ok(students).build();
    }

    @GET
    @Path("/{id}")
    public Response getStudentById(@PathParam("id") int id) {
        return studentService.getStudentById(id)
                .map(student -> Response.ok(student).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @POST
    public Response addStudent(Student student) {
        studentService.addStudent(student);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateStudent(@PathParam("id") int id, Student student) {
        boolean updated = studentService.updateStudent(id, student);
        return updated ? Response.ok().build() : Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteStudent(@PathParam("id") int id) {
        boolean deleted = studentService.deleteStudent(id);
        return deleted ? Response.noContent().build() : Response.status(Response.Status.NOT_FOUND).build();
    }
}