package com.app.service;

import java.util.List;

import com.app.dto.CreatePrescriptionDTO;
import com.app.pojos.Doctor;
import com.app.pojos.Medicine;
import com.app.pojos.Patient;
import com.app.pojos.Prescription;


public interface PrescriptionService {

	public String savePrescription(CreatePrescriptionDTO p);
	public List<Prescription> findPrescriptionByPatient(Patient pat);
	public List<Medicine> getMedicines();
	public List<Prescription> findPrescriptionByDoctor(Doctor doc);
	public Prescription getPrescriptionById(int id);
}
