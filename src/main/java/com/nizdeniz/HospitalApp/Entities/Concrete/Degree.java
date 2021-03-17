package com.nizdeniz.HospitalApp.Entities.Concrete;

import com.nizdeniz.HospitalApp.Entities.Abstract.IEntity;

public class Degree implements IEntity {
    private int Id;
    private String Name;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
