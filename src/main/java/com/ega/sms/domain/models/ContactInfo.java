package com.ega.sms.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContactInfo {

	private String address;
	private String phoneNumber;
	private String emailAddress;

	private Student student;
}
