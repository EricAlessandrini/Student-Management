package com.ega.sms.infrastructure.adapters.input.view.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponse {

	private Long id;
	private String firstName;
	private String lastName;
	private LocalDate birthday;
}
