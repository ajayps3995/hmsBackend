package com.app.controller;

import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.dto.CreatePrescriptionDTO;
import com.app.dto.PrescriptionDTO;
import com.app.dto.PrescriptionDetailsDTO;
import com.app.pojos.Doctor;
import com.app.pojos.Patient;
import com.app.pojos.Prescription;
import com.app.service.DoctorService;
import com.app.service.PatientService;
import com.app.service.PrescriptionService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/prescription")
public class PrescriptionController {

	@Autowired
	private PrescriptionService presserve;
	
	@Autowired
	private PatientService patientService; 
	
	@Autowired
	private DoctorService docservice;
	
	@PostMapping("/add")
	public ResponseEntity<?> addPresciption(@RequestBody CreatePrescriptionDTO prep){
		return ResponseEntity.ok(presserve.savePrescription(prep));
	}
	
	@GetMapping("/show/{id}") 
	public ResponseEntity<?> getPrescriptionsBypatientid(@PathVariable int id){
		Patient p = patientService.findPatientById(id);
		return ResponseEntity.ok(presserve.findPrescriptionByPatient(p).stream()
				.map(prescrip->new PrescriptionDTO(prescrip.getDoc().getName(),p.getName(),prescrip.getDate(),prescrip.getId())).sorted((d1,d2)->d2.getDate().compareTo(d1.getDate()))
						.collect(Collectors.toList()));
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getPrescriptionsByDocid(@PathVariable int id){
		Doctor d = docservice.findDoctorById(id);
		return ResponseEntity.ok(presserve.findPrescriptionByDoctor(d).stream()
				.map(prescrip->new PrescriptionDTO(d.getName(),prescrip.getPatient().getName(),prescrip.getDate(),prescrip.getId())).sorted((d1,d2)->d2.getDate().compareTo(d1.getDate()))
						.collect(Collectors.toList()));

		//		return ResponseEntity.ok(presserve.findPrescriptionByDoctor(d).stream()
//				.map(prescrip->new PrescriptionDTO(prescrip.getDoc().getName(),d.getName(),prescrip.getDate(),
//						prescrip.getPrescriptiondetails().stream().map(details->new PrescriptionDetailsDTO(details.getId(), details.getMedicineid().getName(), details.getDosage(),details.getDuration(), details.getQuantity())).collect(Collectors.toList())))
//				.collect(Collectors.toList()));
	}
	
	@GetMapping("/details/{id}")
	public ResponseEntity<?> getPrescriptionDetailsByprescriptiontid(@PathVariable int id){
		Prescription p = presserve.getPrescriptionById(id);
	
		return ResponseEntity.ok(new PrescriptionDTO(p.getId(), p.getDoc().getName(), p.getPatient().getName(),p.getDate(),p.getPrescriptiondetails().stream()
				.map((ps)->new PrescriptionDetailsDTO(ps.getId(), ps.getMedicineid().getName(), ps.getDosage(), ps.getDuration(), ps.getQuantity())).collect(Collectors.toList())));
	}
	
	@GetMapping("/getmedicines")
	public ResponseEntity<?> getAllMedicines(){
		return ResponseEntity.ok(presserve.getMedicines());
	}
	
}
