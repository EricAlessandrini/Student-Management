package com.ega.sms.domain.models;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {

	private Long id;
	private String firstName;
	private String lastName;
	private LocalDate birthday;

//	private ContactInfo contactInfo;
}
