package com.app.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.DoctorDao;
import com.app.dao.MedicineDao;
import com.app.dao.PatientDao;
import com.app.dao.PrescriptionDao;
import com.app.dto.CreatePrescriptionDTO;
import com.app.dto.CreatePrescriptionDetailsDTO;
import com.app.pojos.Doctor;
import com.app.pojos.Medicine;
import com.app.pojos.Patient;
import com.app.pojos.Prescription;
import com.app.pojos.PrescriptionDetails;

@Transactional
@Service
public class PrescriptionServiceImpl implements PrescriptionService {
	@Autowired
	private DoctorDao docdao;
	@Autowired
	private PatientDao patdao;
	@Autowired
	private MedicineDao meddao;
	@Autowired
	private PrescriptionDao prescripdao;
	
	@Override
	public String savePrescription(CreatePrescriptionDTO p) {
		
	Doctor d=docdao.findById(p.getDoc_id()).orElse(null);
	Patient pat=patdao.findById(p.getP_id()).orElse(null);
	
	Prescription prescription=new Prescription();
	
	prescription.setDate(LocalDate.now());
	for (CreatePrescriptionDetailsDTO predto : p.getPrescriptiondetails()) {
		Medicine med=meddao.findById(predto.getM_id()).orElse(null);
		PrescriptionDetails prescriptiondetail= new PrescriptionDetails();
		prescriptiondetail.setDosage(predto.getDosage());
		prescriptiondetail.setMedicineid(med);
		prescriptiondetail.setDuration(predto.getDuration());
		prescriptiondetail.setQuantity(predto.getQtantiy());
		prescription.addPrescriptiondetails(prescriptiondetail);
	}
	pat.addPrescription(prescription);
	d.addPrescription(prescription);
	
	prescripdao.save(prescription);		
		return "Prescription is added";
	}

	@Override
	public List<Prescription> findPrescriptionByPatient(Patient pat) {
		return prescripdao.findByPatient(pat);
	}

	@Override
	public List<Prescription> findPrescriptionByDoctor(Doctor doc) {
		
		return prescripdao.findByDoc(doc);

	}

	@Override
	public Prescription getPrescriptionById(int id) {
		
		return prescripdao.findById(id).orElseThrow(()-> new ResourceNotFoundException("No Such prescription"));
	}

	@Override
	public List<Medicine> getMedicines() {
		return meddao.findAll();
	}
	
	

}
