package com.ega.sms.signatures;

import java.util.List;

public interface ISignatureService {
	
	// Method to add a new Signature
	
	public Signature registerNewSignature(Signature signature);
	
	// Method to update a registered Signature
	
	public Signature updateExistingSignature(Long id, Signature signature);
	
	// Method to delete a registered Signature
	
	public void deleteExistingSignature(Long id);
	
	// Method to list all registered Signatures
	
	public List<Signature> listAllSignatures();
	
	// Method to look for a specific Signature?
	
	public Signature getExistingSignature(Long id);
}
