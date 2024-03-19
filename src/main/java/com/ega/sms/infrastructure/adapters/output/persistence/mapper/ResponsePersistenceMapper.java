package com.ega.sms.infrastructure.adapters.output.persistence.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.ega.sms.domain.models.Student;
import com.ega.sms.infrastructure.adapters.output.persistence.entity.StudentEntity;

public class ResponsePersistenceMapper {

	public static Student toStudent(StudentEntity studentEntity) {
		Student student = new Student();
		student.setId(studentEntity.getId());
		student.setFirstName(studentEntity.getFirstName());
		student.setLastName(studentEntity.getLastName());
		student.setBirthday(studentEntity.getBirthday());
		return student;
	}
	
	public static List<Student> toStudentList(List<StudentEntity> entityList) {
		List<Student> studentList = entityList.stream()
				.map(studentEntity -> toStudent(studentEntity))
				.collect(Collectors.toList());
		return studentList;
	}
}
