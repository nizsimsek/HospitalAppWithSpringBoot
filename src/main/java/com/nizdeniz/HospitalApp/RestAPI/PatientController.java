package com.nizdeniz.HospitalApp.RestAPI;

import com.nizdeniz.HospitalApp.Business.Concrete.PatientManager;
import com.nizdeniz.HospitalApp.Core.Results.IDataResult;
import com.nizdeniz.HospitalApp.Entities.Concrete.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patient")
public class PatientController {

    private final PatientManager _patientManager;

    @Autowired
    public PatientController(PatientManager patientManager) {
        _patientManager = patientManager;
    }

    @GetMapping("/getall")
    public IDataResult<List<Patient>> GetAll() {
        return _patientManager.GetAll();
    }

    @PostMapping("/add")
    public void Add(@RequestBody Patient patient) {
        _patientManager.Add(patient);
    }

    @PostMapping("/update")
    public void Update(@RequestBody Patient patient) {
        _patientManager.Update(patient);
    }

    @GetMapping("/delete/{id}")
    public void DeleteById(@PathVariable int id) {
        _patientManager.DeleteById(id);
    }

    @GetMapping("/{id}")
    public IDataResult<Patient> GetById(@PathVariable int id) {
        return _patientManager.GetById(id);
    }
}
