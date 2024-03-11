package com.ega.sms.signatures;

import java.util.Objects;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table (name = "signatures")
public class Signature {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "signature_name", nullable = false, length = 100)
	@NotBlank(message = "You must introduce a name for the new signature")
	@Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Only letters allowed")
	private String name;
	
	@Column(nullable = false)
	@NotNull(message = "The amount of credits earned must be detailed")
	@Min(value = 1, message = "Minimum value of 0")
	private Integer credits;
	
	@Pattern(regexp = "^[a-zA-Z\\s]+$", message = "The name of the teachers can only have letters -.-")
	private String teacher;
	
	public Signature() {
		
	}
	
	public Signature(Long id, String name, Integer credits, String teacher) {
		this.id = id;
		this.name  = name;
		this.credits = credits;
		this.teacher = teacher;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCredits() {
		return credits;
	}

	public void setCredits(Integer credits) {
		this.credits = credits;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	@Override
	public String toString() {
		return "Signature id = " + id +"\n"
				+ "Signature name = " + this.name ;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Signature other = (Signature) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}
	
	
}
