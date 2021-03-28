package com.nizdeniz.HospitalApp.RestAPI;

import com.nizdeniz.HospitalApp.Business.Concrete.EmployeeManager;
import com.nizdeniz.HospitalApp.Core.Results.IDataResult;
import com.nizdeniz.HospitalApp.Entities.Concrete.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private final EmployeeManager _employeeManager;

    @Autowired
    public EmployeeController(EmployeeManager employeeManager) {
        _employeeManager = employeeManager;
    }

    @GetMapping("/getall")
    public IDataResult<List<Employee>> GetAll() {
        return _employeeManager.GetAll();
    }

    @PostMapping("/add")
    public void Add(@RequestBody Employee employee) {
        _employeeManager.Add(employee);
    }

    @PostMapping("/update")
    public void Update(@RequestBody Employee employee) {
        _employeeManager.Update(employee);
    }

    @GetMapping("/delete/{id}")
    public void DeleteById(@PathVariable int id) {
        _employeeManager.DeleteById(id);
    }

    @GetMapping("/{id}")
    public IDataResult<Employee> GetById(@PathVariable int id) {
        return _employeeManager.GetById(id);
    }
}
