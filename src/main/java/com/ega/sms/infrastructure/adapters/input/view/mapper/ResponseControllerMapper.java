package com.ega.sms.infrastructure.adapters.input.view.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.ega.sms.domain.models.Student;
import com.ega.sms.infrastructure.adapters.input.view.model.StudentResponse;

public class ResponseControllerMapper {

	public static StudentResponse toStudentResponse(Student student) {
		StudentResponse studentResponse = new StudentResponse();
		studentResponse.setId(student.getId());
		studentResponse.setFirstName(student.getFirstName());
		studentResponse.setLastName(student.getLastName());
		studentResponse.setBirthday(student.getBirthday());
		return studentResponse;
	}

	public static List<StudentResponse> toStudentResponseList(List<Student> studentList) {
		List<StudentResponse> toStudentResponseList = studentList.stream()
				.map(student -> toStudentResponse(student))
				.collect(Collectors.toList());
		return toStudentResponseList;
	}
}
