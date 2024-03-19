package com.ega.sms.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ega.sms.application.ports.input.StudentServicePort;
import com.ega.sms.application.ports.output.StudentPersistencePort;
import com.ega.sms.domain.exceptions.StudentNotFoundException;
import com.ega.sms.domain.models.Student;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService implements StudentServicePort {

	private final StudentPersistencePort persistencePort;

	@Override
	public Student saveStudent(Student student) {
		return persistencePort.saveStudent(student);
	}

	@Override
	public Student updateStudent(Long id, Student student) {
		return persistencePort.findStudentById(id)
				.map(savedStudent -> {
					savedStudent.setId(student.getId());
					savedStudent.setFirstName(student.getFirstName());
					savedStudent.setLastName(student.getLastName());
					savedStudent.setBirthday(student.getBirthday());
					return persistencePort.saveStudent(savedStudent);
				})
				.orElseThrow(StudentNotFoundException::new);
	}

	@Override
	public Student findStudentById(Long id) {
		return persistencePort.findStudentById(id)
				.orElseThrow(StudentNotFoundException::new);
	}

	@Override
	public List<Student> retrieveAllStudents() {
		return persistencePort.findAllStudents();
	}

	@Override
	public void deleteStudentById(Long id) {
		if(persistencePort.findStudentById(id).isEmpty()) {
			throw new StudentNotFoundException();
		}

		persistencePort.deleteStudentById(id);
	}

}
