package ir.hospital.hospitalmicroservice.controller;

import ir.hospital.hospitalmicroservice.dto.ClinicDto;
import ir.hospital.hospitalmicroservice.dto.PatientDto;
import ir.hospital.hospitalmicroservice.dto.PatientRegisterDto;
import ir.hospital.hospitalmicroservice.dto.QueuingDto;
import ir.hospital.hospitalmicroservice.entity.Patient;
import ir.hospital.hospitalmicroservice.service.ClinicService;
import ir.hospital.hospitalmicroservice.service.PatientService;
import ir.hospital.hospitalmicroservice.service.QueuingService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/hospital/patient")
public class PatientController {

    private final PatientService patientService;
    private final QueuingService queuingService;
    private final ClinicService clinicService;

    @PostMapping
    public void register(@RequestBody PatientRegisterDto patientRegisterDto){
        patientService.signup(PatientRegisterDto.patientRegisterDtoToPatient(patientRegisterDto));
    }

    @GetMapping
    public PatientDto myDetailDto(Authentication authentication) {
        Patient patient = (Patient) authentication.getPrincipal();
        return PatientDto.patientToPatientDto(patientService.myDetail(patient.getId()));
    }

    @PostMapping("/addQueue")
    public void addQueue(@RequestBody QueuingDto queueDto, Authentication authentication) {
        Patient patient = (Patient) authentication.getPrincipal();
        queuingService.addQueuing(QueuingDto.queuingDtoToQueuing(queueDto, patient));
    }

    @GetMapping("/show-clinics")
    public List<ClinicDto> showClinics(){
        return clinicService.fetchAll().stream().map(ClinicDto::clinicToClinicDto).toList();
    }

}
