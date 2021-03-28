package com.nizdeniz.HospitalApp.RestAPI;

import com.nizdeniz.HospitalApp.Business.Concrete.FieldManager;
import com.nizdeniz.HospitalApp.Core.Results.IDataResult;
import com.nizdeniz.HospitalApp.Entities.Concrete.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/field")
public class FieldController {

    private final FieldManager _fieldManager;

    @Autowired
    public FieldController(FieldManager fieldManager) {
        _fieldManager = fieldManager;
    }

    @GetMapping("/getall")
    public IDataResult<List<Field>> GetAll() {
        return _fieldManager.GetAll();
    }

    @PostMapping("/add")
    public void Add(@RequestBody Field field) {
        _fieldManager.Add(field);
    }

    @PostMapping("/update")
    public void Update(@RequestBody Field field) {
        _fieldManager.Update(field);
    }

    @GetMapping("/delete/{id}")
    public void DeleteById(@PathVariable int id) {
        _fieldManager.DeleteById(id);
    }

    @GetMapping("/{id}")
    public IDataResult<Field> GetById(@PathVariable int id) {
        return _fieldManager.GetById(id);
    }
}
