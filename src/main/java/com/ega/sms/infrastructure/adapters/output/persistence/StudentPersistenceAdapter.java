package com.ega.sms.infrastructure.adapters.output.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.ega.sms.application.ports.output.StudentPersistencePort;
import com.ega.sms.domain.models.Student;
import com.ega.sms.infrastructure.adapters.output.persistence.entity.StudentEntity;
import com.ega.sms.infrastructure.adapters.output.persistence.mapper.RequestPersistenceMapper;
import com.ega.sms.infrastructure.adapters.output.persistence.mapper.ResponsePersistenceMapper;
import com.ega.sms.infrastructure.adapters.output.persistence.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class StudentPersistenceAdapter implements StudentPersistencePort{
	
	private final StudentRepository repository;

	@Override
	public Student saveStudent(Student student) {
		StudentEntity studentToSave = RequestPersistenceMapper.toStudentEntity(student);
		repository.save(studentToSave);
		return ResponsePersistenceMapper.toStudent(studentToSave);
	}

	@Override
	public Optional<Student> findStudentById(Long id) {
		return repository.findById(id)
				.map(studentInDb -> ResponsePersistenceMapper.toStudent(studentInDb));
	}

	@Override
	public List<Student> findAllStudents() {
		List<Student> requestedStudents = ResponsePersistenceMapper.toStudentList(repository.findAll());
		return requestedStudents;
	}

	@Override
	public void deleteStudentById(Long id) {
		repository.deleteById(id);
	}

}
