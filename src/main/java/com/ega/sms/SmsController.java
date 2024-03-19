package com.ega.sms;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SmsController {

	@GetMapping("/")
	public String paginaInicio() {
		return "index";
	}
}
