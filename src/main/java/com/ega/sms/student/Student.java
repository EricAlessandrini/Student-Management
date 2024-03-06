package com.ega.sms.student;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table (name = "students")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idStudent;
	
	@Pattern(regexp = "^[A-Z][a-z]*$", message = "Only letters allowed")
	@NotBlank(message = "Name required")
	@Column(name = "student_name")
	private String nameStudent;
	
	@Pattern(regexp = "^[A-Z][a-z]*$", message = "Only letters allowed")
	@NotBlank(message = "Lastname required")
	@Column(name = "student_lastname")
	private String lastNameStudent;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "Birthday required")
	@Column(name = "student_birthday")
	@Past(message = "You must enter a date that is previous to this moment")
	private LocalDate birthdayStudent;
	
	@Email(message = "Invalid email format")
	@NotBlank(message = "You must enter an email address")
	@Column(name = "student_email")
	private String emailStudent;
	
	@Pattern(regexp = "\\d+", message = "Only numbers allowed")
	@Size(max = 6, message = "Max. length of 6 numbers")
	@NotBlank(message = "You must enter your tuition number")
	@Column(name = "student_tuition")
	private String tuitionNumber;
	
	public Student() {
		
	}

	public Student(Long idStudent, @NotBlank(message = "Name required") String nameStudent,
			@NotBlank(message = "Lastname required") String lastNameStudent,
			@Past(message = "You must enter a date that is previous to this moment") LocalDate birthdayStudent,
			@Email(message = "Invalid email format") @NotBlank(message = "You must enter an email address") String emailStudent,
			@Pattern(regexp = "\\d+", message = "Only numbers allowed") @Size(max = 6, message = "Max. length of 6 numbers") @NotBlank(message = "You must enter your tuition number") String tuitionNumber) {
		this.idStudent = idStudent;
		this.nameStudent = nameStudent;
		this.lastNameStudent = lastNameStudent;
		this.birthdayStudent = birthdayStudent;
		this.emailStudent = emailStudent;
		this.tuitionNumber = tuitionNumber;
	}

	public Long getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(Long idStudent) {
		this.idStudent = idStudent;
	}

	public String getNameStudent() {
		return nameStudent;
	}

	public void setNameStudent(String nameStudent) {
		this.nameStudent = nameStudent;
	}

	public String getLastNameStudent() {
		return lastNameStudent;
	}

	public void setLastNameStudent(String lastNameStudent) {
		this.lastNameStudent = lastNameStudent;
	}

	public LocalDate getBirthdayStudent() {
		return birthdayStudent;
	}

	public void setBirthdayStudent(LocalDate birthdayStudent) {
		this.birthdayStudent = birthdayStudent;
	}

	public String getEmailStudent() {
		return emailStudent;
	}

	public void setEmailStudent(String emailStudent) {
		this.emailStudent = emailStudent;
	}

	public String getTuitionNumber() {
		return tuitionNumber;
	}

	public void setTuitionNumber(String tuitionNumber) {
		this.tuitionNumber = tuitionNumber;
	}

	@Override
	public String toString() {
		return "Student [idStudent=" + idStudent + ", nameStudent=" + nameStudent + ", lastNameStudent="
				+ lastNameStudent + ", birthdayStudent=" + birthdayStudent + ", emailStudent=" + emailStudent
				+ ", tuitionNumber=" + tuitionNumber + "]";
	}
	
	
}
