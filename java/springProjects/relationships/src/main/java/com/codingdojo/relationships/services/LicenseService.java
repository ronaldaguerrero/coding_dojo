package com.codingdojo.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.relationships.models.License;
import com.codingdojo.relationships.repositories.LicenseRepo;

@Service
public class LicenseService {
	
	private final LicenseRepo licenseRepo;
	
	public LicenseService(LicenseRepo licenseRepo) {
		this.licenseRepo = licenseRepo;
	}
	
	public License createLicense(License l) {
		return licenseRepo.save(l);
	}

	public List<License> allLicenses() {
		return licenseRepo.findAll();
	}
	
	public static int licenseNumber;
	
	public Optional<License> getLicense(Long id) {
		return licenseRepo.findById(id);
	}
	
	public String formatLicenseNumber(int num) {
		String format = String.format("%06d", num);
		return format;
	}
	
	public String generateLicenseNumber() {
		if(licenseRepo.findTopByOrderByNumberDesc().isEmpty()) {
			licenseNumber +=1;
			return formatLicenseNumber(licenseNumber);
		}
		else {
			List<License> license = licenseRepo.findTopByOrderByNumberDesc();
			licenseNumber = 1+(Integer.parseInt(license.get(0).getNumber()));
			return formatLicenseNumber(licenseNumber);
		}
	}
	
}
