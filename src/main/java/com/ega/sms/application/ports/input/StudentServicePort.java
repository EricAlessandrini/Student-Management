package com.ega.sms.application.ports.input;

import java.util.List;

import com.ega.sms.domain.models.Student;


public interface StudentServicePort {

	// Find a Student by his ID
	public Student findStudentById (Long id);

	// Retrieve all Student
	public List<Student> retrieveAllStudents();

	// Save a new Student
	public Student saveStudent (Student student);

	// Update the info of a new Student
	public Student updateStudent (Long id, Student student);

	// Delete a Student
	public void deleteStudentById(Long id);
}
