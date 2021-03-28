package com.nizdeniz.HospitalApp.RestAPI;

import com.nizdeniz.HospitalApp.Business.Concrete.DegreeManager;
import com.nizdeniz.HospitalApp.Core.Results.IDataResult;
import com.nizdeniz.HospitalApp.Entities.Concrete.Degree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/degree")
public class DegreeController {

    private final DegreeManager _degreeManager;

    @Autowired
    public DegreeController(DegreeManager degreeManager) {
        _degreeManager = degreeManager;
    }

    @GetMapping("/getall")
    public IDataResult<List<Degree>> GetAll() {
        return _degreeManager.GetAll();
    }

    @PostMapping("/add")
    public void Add(@RequestBody Degree degree) {
        _degreeManager.Add(degree);
    }

    @PostMapping("/update")
    public void Update(@RequestBody Degree degree) {
        _degreeManager.Update(degree);
    }

    @GetMapping("/delete/{id}")
    public void DeleteById(@PathVariable int id) {
        _degreeManager.DeleteById(id);
    }

    @GetMapping("/{id}")
    public IDataResult<Degree> GetById(@PathVariable int id){
        return _degreeManager.GetById(id);
    }
}
