package com.ega.sms.infrastructure.adapters.input.view.model;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequest {

	private Long id;
	@NotBlank(message = "Name is required")
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Name can only contain letters")
	private String firstName;
	@NotBlank(message = "Last name is required")
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Last name can only contain letters")
	private String lastName;
	@NotNull(message = "Birthday is required")
	@Past(message = "This date must be from the past always")
	private LocalDate birthday;

}
