package com.ega.sms.infrastructure.adapters.output.persistence.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.ega.sms.domain.models.Student;
import com.ega.sms.infrastructure.adapters.output.persistence.entity.StudentEntity;

public class RequestPersistenceMapper {

	public static StudentEntity toStudentEntity(Student student) {
		StudentEntity studentEntity = new StudentEntity();
		studentEntity.setId(student.getId());
		studentEntity.setFirstName(student.getFirstName());
		studentEntity.setLastName(student.getLastName());
		studentEntity.setBirthday(student.getBirthday());
		return studentEntity;
	}
	
	public static List<StudentEntity> toEntityList(List<Student> studentList) {
		List<StudentEntity> entityList = studentList.stream()
				.map(student -> toStudentEntity(student))
				.collect(Collectors.toList());
		return entityList;
	}
}
