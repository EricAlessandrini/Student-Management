package com.ega.sms.signatures;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignatureServiceImpl implements ISignatureService {
	
	private SignatureRepository signatureRepository;
	
	@Autowired
	public SignatureServiceImpl (SignatureRepository signatureRepository) {
		this.signatureRepository = signatureRepository;
	}

	@Override
	public Signature registerNewSignature(Signature signature) {
		return signatureRepository.save(signature);
	}

	@Override
	public Signature updateExistingSignature(Long id, Signature signature) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteExistingSignature(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Signature> listAllSignatures() {
		return signatureRepository.findAll();
	}

	@Override
	public Signature getExistingSignature(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
