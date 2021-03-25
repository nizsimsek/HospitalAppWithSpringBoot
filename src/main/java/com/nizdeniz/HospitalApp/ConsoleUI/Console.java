package com.nizdeniz.HospitalApp.ConsoleUI;

import com.nizdeniz.HospitalApp.Business.Concrete.DegreeManager;
import com.nizdeniz.HospitalApp.Business.Concrete.PatientManager;
import com.nizdeniz.HospitalApp.Business.Concrete.UserManager;
import com.nizdeniz.HospitalApp.DataAccess.Concrete.DriverManager.DegreeDal;
import com.nizdeniz.HospitalApp.DataAccess.Concrete.DriverManager.PatientDal;
import com.nizdeniz.HospitalApp.DataAccess.Concrete.DriverManager.UserDal;
import com.nizdeniz.HospitalApp.Entities.Concrete.Degree;
import com.nizdeniz.HospitalApp.Entities.Concrete.Patient;
import com.nizdeniz.HospitalApp.Entities.Concrete.User;

public class Console {
    public static void main(String[] args) {
        DegreeManager degreeManager = new DegreeManager(new DegreeDal());
        PatientManager patientManager = new PatientManager(new PatientDal());
        UserManager userManager = new UserManager(new UserDal());

        //DEGREE INFORMATION
        for (Degree degree : degreeManager.GetAll()) {
            System.out.println("DegreeId : " + degree.getId());
            System.out.println("DegreeName : " + degree.getName());
            System.out.println("------------------------------------------");
        }

        //PATIENT INFORMATION
        for (Patient patient : patientManager.GetAll()) {
            System.out.println("PatientId : " + patient.getId());
            System.out.println("PatientName : " + patient.getName());
            System.out.println("PatientSurame : " + patient.getSurname());
            System.out.println("PatientNationalId : " + patient.getNationalId());
            System.out.println("PatientFieldId : " + patient.getFieldId());
            System.out.println("PatientPhoneNumber : " + patient.getPhoneNumber());
            System.out.println("PatientCreatedDate : " + patient.getCreatedDate());
            System.out.println("PatientEmail : " + patient.getEmail());
            System.out.println("------------------------------------------");
        }

        //USER INFORMATION
        for (User user : userManager.GetAll()) {
            System.out.println("UserId : " + user.getId());
            System.out.println("UserEmail : " + user.getEmail());
            System.out.println("UserPasswordHash : " + user.getPasswordHash());
            System.out.println("UserPasswordSalt : " + user.getPasswordSalt());
            System.out.println("UserRoleId : " + user.getRoleId());
            System.out.println("------------------------------------------");
        }
    }
}
