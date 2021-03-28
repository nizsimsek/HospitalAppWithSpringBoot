package com.nizdeniz.HospitalApp.RestAPI;

import com.nizdeniz.HospitalApp.Business.Concrete.EmployeeStatusManager;
import com.nizdeniz.HospitalApp.Core.Results.IDataResult;
import com.nizdeniz.HospitalApp.Entities.Concrete.EmployeeStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee_status")
public class EmployeeStatusController {

    private final EmployeeStatusManager _employeeStatusManager;

    @Autowired
    public EmployeeStatusController(EmployeeStatusManager employeeStatusManager) {
        _employeeStatusManager = employeeStatusManager;
    }

    @GetMapping("/getall")
    public IDataResult<List<EmployeeStatus>> GetAll() {
        return _employeeStatusManager.GetAll();
    }

    @PostMapping("/add")
    public void Add(@RequestBody EmployeeStatus employeeStatus) {
        _employeeStatusManager.Add(employeeStatus);
    }

    @PostMapping("/update")
    public void Update(@RequestBody EmployeeStatus employeeStatus) {
        _employeeStatusManager.Update(employeeStatus);
    }

    @GetMapping("/delete/{id}")
    public void DeleteById(int id) {
        _employeeStatusManager.DeleteById(id);
    }

    @GetMapping("/{id}")
    public IDataResult<EmployeeStatus> GetById(@PathVariable int id) {
        return _employeeStatusManager.GetById(id);
    }
}
