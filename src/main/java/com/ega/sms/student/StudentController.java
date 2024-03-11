package com.ega.sms.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import jakarta.validation.Valid;

@Controller
public class StudentController {

	private IStudentService studentService;
	
	@Autowired
	public StudentController(IStudentService studentService) {
		this.studentService = studentService;
	}
	
	// Method to show form for new student registration
	
	@GetMapping("/studentRegistrationForm")
	public String registrationForm(Model model) {
		model.addAttribute("student", new Student());
		return "studentForm";
	}
	
	// Method to receive the information of new Student and save it on our DB
	
	@PostMapping("/registerStudent")
	public String saveNewStudent(@Valid @ModelAttribute Student student, BindingResult result) {
		
		if(result.hasErrors()) {
			return "studentForm";
		}
		
		studentService.saveNewStudent(student);
		return "redirect:/studentsList";
	}
	
	// Method to list all Students registered on DB
	
	@GetMapping("/studentsList")
	public String getAllStudents(Model model) {
		List<Student> studentsList = studentService.getAllStudents();
		model.addAttribute("studentsList", studentsList);
		return "studentsList";
	}
	
	// Method to show the form used to update data registered of Students in DB
	
	@GetMapping("/{id}/editStudentForm")
	public String getStudentToEdit(@PathVariable Long id, Model model) {
		Student studentFromDB = studentService.getStudentById(id);
		System.out.println(studentFromDB.getIdStudent());
		model.addAttribute("studentFromDB", studentFromDB);
		return "studentEditForm";
	}
	
	// Method to actually update the information of a Student inside the DB
	
	@PostMapping("/editStudent")
	public String updateStudent(@Valid @ModelAttribute("studentFromDB") Student student, BindingResult result) {
		
		if(result.hasErrors()) {
			return "studentEditForm";
		}
		
		studentService.updateStudent(student.getIdStudent(), student);
		return "redirect:/studentsList";
	}
	
	// Method to delete a Student from the system (out of DB thus out of list too)
	
	@GetMapping("/{id}/deleteStudent")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudentById(id);
		return "redirect:/studentsList";
	}
}
