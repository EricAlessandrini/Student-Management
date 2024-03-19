package com.ega.sms.infrastructure.adapters.input.view;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ega.sms.application.ports.input.StudentServicePort;
import com.ega.sms.domain.models.Student;
import com.ega.sms.infrastructure.adapters.input.view.mapper.RequestControllerMapper;
import com.ega.sms.infrastructure.adapters.input.view.mapper.ResponseControllerMapper;
import com.ega.sms.infrastructure.adapters.input.view.model.StudentRequest;
import com.ega.sms.infrastructure.adapters.input.view.model.StudentResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentViewController {

	private final StudentServicePort servicePort;

	@GetMapping("/all")
	public String getAllStudents(Model model) {
		List<StudentResponse> studentsFromDB = ResponseControllerMapper.toStudentResponseList(servicePort.retrieveAllStudents());
		model.addAttribute("studentList", studentsFromDB);
		return "student/studentList";
	}

	@GetMapping("/registrationForm")
	public String displayStudentRegistrationForm(Model model) {
		model.addAttribute("student", new StudentRequest());
		return "student/studentRegistrationForm";
	}

	@PostMapping("/register")
	public String saveNewStudent(@Valid @ModelAttribute("student") StudentRequest studentRequest, BindingResult result) {
		if(result.hasErrors()) {
			return "student/studentRegistrationForm";
		}
		Student student = RequestControllerMapper.toStudent(studentRequest);
		servicePort.saveStudent(student);
		return "redirect:/students/all";
	}
	
	@GetMapping("/{id}/updatingForm")
	public String displayStudentUpdatingForm(@PathVariable Long id, Model model) {
		StudentResponse studentToUpdate = ResponseControllerMapper.toStudentResponse(servicePort.findStudentById(id));
		model.addAttribute("updatingStudent", studentToUpdate);
		return "student/studentUpdatingForm";
	}
	
	@PostMapping("/{id}/update")
	public String updateStudent(@Valid @ModelAttribute("updatingStudent") StudentRequest studentRequest, BindingResult result) {
		if(result.hasErrors()) {
			return "student/studentUpdatingForm";
		}
		
		Student student = RequestControllerMapper.toStudent(studentRequest);
		servicePort.updateStudent(student.getId(), student);
		return "redirect:/students/all";
	}
	
	@PostMapping("/{id}")
	public String deleteStudent(@PathVariable Long id) {
		servicePort.deleteStudentById(id);
		return "redirect:/students/all";
	}

}
