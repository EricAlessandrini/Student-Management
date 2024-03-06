package com.ega.sms.student;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements IStudentService{
	
	private StudentRepository studentRepository;
	
	@Autowired
	public StudentServiceImpl(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@Override
	public Student saveNewStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student updateStudent(Long id, Student student) {
		Student studentFromDB = studentRepository.findById(id).get();
		
		if(Objects.nonNull(student.getNameStudent()) && !"".equalsIgnoreCase(student.getNameStudent())) {
			studentFromDB.setNameStudent(student.getNameStudent());
		}
		if(Objects.nonNull(student.getLastNameStudent()) && !"".equalsIgnoreCase(student.getLastNameStudent())) {
			studentFromDB.setLastNameStudent(student.getLastNameStudent());
		}
		if(Objects.nonNull(student.getBirthdayStudent())) {
			studentFromDB.setBirthdayStudent(student.getBirthdayStudent());
		}
		if (Objects.nonNull(student.getEmailStudent()) && !"".equalsIgnoreCase(student.getEmailStudent())) {
			studentFromDB.setEmailStudent(student.getEmailStudent());
		}
		if (Objects.nonNull(student.getTuitionNumber()) && !"".equalsIgnoreCase(student.getTuitionNumber())) {
			studentFromDB.setTuitionNumber(student.getTuitionNumber());
		}
		
		studentRepository.save(studentFromDB);
		
		return studentFromDB;
	}

	@Override
	public void deleteStudentById(Long id) {
		studentRepository.deleteById(id);
	}

	@Override
	public Student getStudentById(Long id) {
		return studentRepository.findById(id).get();
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

}
