package com.nizdeniz.HospitalApp.RestAPI;

import com.nizdeniz.HospitalApp.Business.Concrete.UserManager;
import com.nizdeniz.HospitalApp.Core.Results.IDataResult;
import com.nizdeniz.HospitalApp.Entities.Concrete.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserManager _userManager;

    @Autowired
    public UserController(UserManager userManager) {
        _userManager = userManager;
    }

    @GetMapping("/getall")
    public IDataResult<List<User>> GetAll() {
        return _userManager.GetAll();
    }

    @PostMapping("/add")
    public void Add(@RequestBody User user) {
        _userManager.Add(user);
    }

    @PostMapping("/update")
    public void Update(@RequestBody User user) {
        _userManager.Update(user);
    }

    @GetMapping("/delete/{id}")
    public void DeleteById(@PathVariable int id) {
        _userManager.DeleteById(id);
    }

    @GetMapping("/{id}")
    public IDataResult<User> GetById(@PathVariable int id){
        return _userManager.GetById(id);
    }
}
