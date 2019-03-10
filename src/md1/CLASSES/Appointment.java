/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md1.CLASSES;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


/**
 *
 * @author Edgars Hartmanis 3ITB
 * Appointment class
 */
public class Appointment {
    private int appId;
    static int appCounter;
    private Date date;
    private String description;
    private Patient patient;
    private ArrayList<Doctor> doctors;
    
    public Appointment(Date date, String description, Patient patient, ArrayList<Doctor> doctors) {
        this.date = date;
        this.description = description;
        this.patient = patient;
        this.doctors = doctors;
        appCounter++;
    }

    public int getAppId() {
        return appId;
    }

    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public void setAppId(int appId) {
        if (appId >= 0) {
            this.appId = appId;   
        } else {
            System.out.println("Couldn't set Appointments id, conditions didn't match");
        }
    }

    public void setDate(Date date) {
        if (date != null) {
            this.date = date;
        } else {
            System.out.println("Couldn't set Appointments date, conditions didn't match");
        }
    }

    public void setDescription(String description) {
        if (description != null && !description.isEmpty()) {
            this.description = description;
        } else {
            System.out.println("Couldn't set Appointments description, conditions didn't match");
        }
    }

    public Patient getPatient() {
        return patient;
    }

    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }

    public void setPatient(Patient patient) {
        if (patient.getClass() == Patient.class) {
            this.patient = patient;
        } else {
            System.out.println("Couldn't set new patient, because given variable is not instance of Patient class");
        }
    }

    public void setDoctors(ArrayList<Doctor> doctors) {
        if (!doctors.isEmpty()) {
            this.doctors = doctors;
        } else {
            System.out.println("Couldn't set Appointments doctor list, list was empty");
        }
    }
    
    public void printInvolvedDoctors() {
        for(Doctor d : doctors) {
            d.toString();
        }
    }
    
    public boolean addNewDoctorToAppoitnment(Doctor doc) {
       try {
            doctors.add(doc);
            System.out.println("Added new doctor to the list");
            return true;
       } catch (Exception e) {
           System.out.println(e.getMessage());
           return false;
       }
    }
    
    public boolean removeExistingDoctorFromAppoitnment(Doctor doc) {
        try {
            doctors.remove(doc);
            System.out.println("Remove doctor from the list");
            return true;
       } catch (Exception e) {
           System.out.println(e.getMessage());
           return false;
       }
    }

    @Override
    public String toString() {
        return "Appointment{" + "appId=" + appId + ", date=" + date + ", description=" + description + ", patient=" + patient + ", doctors=" + doctors + '}';
    }
}
