package com.ega.sms.student;

import java.util.List;

public interface IStudentService {

	public Student saveNewStudent(Student student);
	
	public Student updateStudent(Long id, Student student);
	
	public void deleteStudentById(Long id);
	
	public Student getStudentById(Long id);
	
	public List<Student> getAllStudents();
}
