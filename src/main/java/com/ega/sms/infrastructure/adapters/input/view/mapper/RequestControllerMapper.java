package com.ega.sms.infrastructure.adapters.input.view.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.ega.sms.domain.models.Student;
import com.ega.sms.infrastructure.adapters.input.view.model.StudentRequest;

public class RequestControllerMapper {

	public static Student toStudent(StudentRequest studentRequest) {
		Student student = new Student();
		student.setId(studentRequest.getId());
		student.setFirstName(studentRequest.getFirstName());
		student.setLastName(studentRequest.getLastName());
		student.setBirthday(studentRequest.getBirthday());
		return student;
	}

	public static List<Student> toStudentList(List<StudentRequest> studentRequestList){
		List<Student> toStudentList = studentRequestList.stream()
				.map(studentRequest -> toStudent(studentRequest))
				.collect(Collectors.toList());
		return toStudentList;
	}
}
