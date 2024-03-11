package com.ega.sms.signatures;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@Controller
public class SignatureController {
	
	private ISignatureService signatureService;
	
	public SignatureController(ISignatureService signatureService) {
		this.signatureService = signatureService;
	}

	// Method to show the form for a new Signature
	
	@GetMapping("/newSignatureForm")
	public String showSignatureRegistrationForm(Model model) {
		model.addAttribute("signature", new Signature());
		return "signatureRegistrationForm";
	}
	
	// Method to add a new Signature to DB
	
	@PostMapping("/registerSignature")
	public String addNewSignature(@Valid @ModelAttribute Signature signature, BindingResult results) {
		
		if (results.hasErrors()) {
			return "signatureRegistrationForm";
		}
		
		signatureService.registerNewSignature(signature);
		return "redirect:/signaturesList";
	}
	
	// Method to list all registered Signatures in the DB
	
	@GetMapping("/signaturesList")
	public String listAllRegisteredSignatures(Model model) {
		List<Signature> registeredSignatures = signatureService.listAllSignatures();
		model.addAttribute("allSignatures", registeredSignatures);
		return "signaturesList";
	}
	
}
