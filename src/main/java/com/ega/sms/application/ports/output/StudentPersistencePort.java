package com.ega.sms.application.ports.output;

import java.util.List;
import java.util.Optional;

import com.ega.sms.domain.models.Student;

public interface StudentPersistencePort {

	// Save Student + Update Student
	public  Student saveStudent(Student student) ;
	// Find a Student by his ID
	public Optional<Student> findStudentById(Long id);
	// Find all Students
	public List<Student> findAllStudents();
	// Delete Student
	public void deleteStudentById(Long id);
}
