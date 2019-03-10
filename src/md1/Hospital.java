package md1;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import md1.CLASSES.*;
import md1.ENUMS.*;

/**
 *
 * @author Edgars Hartmanis 3ITB
 * Main Hospital class
 */

public class Hospital {

    private String hospitalName;
    
    private ArrayList<Doctor> doctors;
    private ArrayList<Patient> patients;
    private ArrayList<Appointment> appointmentList;
    
    Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
        doctors = new ArrayList<Doctor>();
        patients = new ArrayList<Patient>();
        appointmentList = new ArrayList<Appointment>();
    }
    
    @Override
    public String toString() {
        return "Hospital{hospitalName=" + hospitalName + "}";
    }
    
    public ArrayList<Doctor> getDoctorsInHospital() {
        return doctors;
    }
    
    public void setDoctorsInHospital(ArrayList<Doctor> docs) {
        this.doctors = docs;
    }
    
    public ArrayList<Appointment> getAppointmentsInHospital() {
        return appointmentList;
    }
    
    public void setAppointmentsInHospital(ArrayList<Appointment> appointments) {
        this.appointmentList = appointments;
    }
    
    public ArrayList<Patient> getPatientsInHospital() {
        return patients;
    }
    
    public void setPatientsInHospital(ArrayList<Patient> patients) {
        this.patients = patients;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }
    
    public boolean addNewPatientInHospital(Patient patient) {
        try {
            patients.add(patient);
            return true;
        } catch (Exception e) {
            throw e;
        }    
    }
    
    public boolean deleteExistingPatientInHospitalById(int id) {
        try {
            for(int i = 0; i < patients.size(); i++) {
                if (patients.get(i).getPatientId() == id) {
                    patients.remove(patients.get(i));
                }
            }
            return true;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public boolean deleteExistingPatientInHospitalByObject(Patient patient) {
        try {
            for(int i = 0; i < patients.size(); i++) {
                if (patients.get(i).equals(patient)) {
                    patients.remove(patients.get(i));
                }
            }
            return true;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public boolean addNewDoctorInHospital(Doctor doc) {
        try {
            doctors.add(doc);
            return true;
        } catch (Exception e) {
            throw e;
        }  
    }
    
    public boolean deleteExistingDoctorInHospitalById(int id) {
        try {
            for(int i = 0; i < doctors.size(); i++) {
                if (doctors.get(i).getDoctorId()== id) {
                    doctors.remove(doctors.get(i));
                }
            }
            return true;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public boolean deleteExistingDoctorInHospitalByObject(Doctor doc) {
        try {
            for(int i = 0; i < doctors.size(); i++) {
                if (doctors.get(i).equals(doc)) {
                    doctors.remove(doctors.get(i));
                }
            }
            return true;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void generateDoctorsInHospital() {
        Random rnd = new Random();
        String [] name = {"Janis", "Edgars", "Ricards", "Kristians", "Aris"};
        String [] surname = {"Berzs", "Celms", "Vilks", "Priede", "Mezs"};
        Gender [] genders = {Gender.male, Gender.female};
        Nationality [] nationalities = {Nationality.Estonian, Nationality.Latvian};
        Speciality [] specialities = {Speciality.Heart, Speciality.Kid};
//        short e = (short)rnd.nextInt(45);
    }
    
    public boolean makeNewAppointment(Date date, String description, Patient patient, ArrayList<Doctor> docs) {
        Appointment a = new Appointment(date, description, patient, docs);
        boolean notCapable = false;
        try {
            if (!appointmentList.isEmpty()) {
                for (int i = 0; i < appointmentList.size(); i++) {
                    if (appointmentList.get(i).getDate().getTime() == date.getTime()) {
                        notCapable = true;
                    }
                }
                
                if (notCapable) {
                    System.out.println("Couldn't add appointment, please choose different time");
                } else {
                    appointmentList.add(a);
                }
            } else {
                appointmentList.add(a);
            }
            
            return true;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public boolean deleteExistingAppointment(Patient patient, Date date) {
        try {
            for(int i = 0; i < appointmentList.size(); i++) {
                if (appointmentList.get(i).getPatient() == patient && appointmentList.get(i).getDate().equals(date)) {
                    appointmentList.remove(appointmentList.get(i));
                }
            }
            return true;
        } catch (Exception e) {
            throw e;
        }
    }
  
    public void printAllPatientsInHospital(){
        for (int i = 0; i < patients.size(); i++) {
            System.out.println(patients.get(i)); 
        }
    }
    
    public void printAllDoctorsInHospital(){
        for (int i = 0; i < doctors.size(); i++) {
            System.out.println(doctors.get(i)); 
        }
    }
    
    public void printAllAppointmentsInHospital(){
        for (int i = 0; i < appointmentList.size(); i++) {
            System.out.println(appointmentList.get(i)); 
        }
    }
    
    public void printAllPatientForDate(Date date){
        for (int i = 0; i < appointmentList.size(); i++) {
            if (appointmentList.get(i).getDate().equals(date)) {
                System.out.println(appointmentList.get(i).getPatient()); 
            }
        }
    }
    
    public void printAllAppointmentsForPatient(Patient patient){
        for (int i = 0; i < appointmentList.size(); i++) {
            if (appointmentList.get(i).getPatient().equals(patient)) {
                System.out.println(appointmentList.get(i)); 
            }
        }
    }

    public void generateAndPrintDayPlanForDoctor(Doctor doc, Date date){
        
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Hospital hospital = new Hospital("Ventspils Hospitāls");
        
        // ArrayList List
        ArrayList<Doctor> doctorListTest = new ArrayList<Doctor>();
        ArrayList<Patient> patientsListTest = new ArrayList<Patient>();
        ArrayList<Appointment> appointmentsListTest = new ArrayList<Appointment>();
        
        //Doctors
        Doctor d1 = new Doctor("Bob", "Burger", 0, Gender.male, Nationality.Estonian, Speciality.Heart, (short)30);
        doctorListTest.add(d1);
        Doctor d2 = new Doctor("Loenardo", "Da Vinci", 1, Gender.male, Nationality.Latvian, Speciality.Kid, (short)23);
        doctorListTest.add(d2);
        Doctor d3 = new Doctor("Maya", "Cloud", 2, Gender.female, Nationality.Latvian, Speciality.Heart, (short)36);
        doctorListTest.add(d3);
        Doctor d4 = new Doctor("Greg", "Fire", 3, Gender.male, Nationality.Latvian, Speciality.Kid, (short)39);
        
        //Patients
        Patient patient1 = new Patient("Edgars", "Hartmanis", 0, Gender.male, Nationality.Latvian, true);
        patientsListTest.add(patient1);
        Patient patient2 = new Patient("Normunds", "Berzs", 1, Gender.male, Nationality.Estonian, false);
        patientsListTest.add(patient2);
        Patient patient3 = new Patient("Baiba", "Karale", 2, Gender.female, Nationality.Latvian, true);
        patientsListTest.add(patient3);
        Patient patient4 = new Patient("Aija", "Celma", 3, Gender.female, Nationality.Latvian, true);
        
        /**
         * MAIN TASKS FOR HOSPITAL IS
         */
        
        // Add doctors and patients
        System.out.println("ADD DOCTOR AND PATIENT:\n");
        
        hospital.addNewDoctorInHospital(d2);
        hospital.addNewDoctorInHospital(d3);
        hospital.addNewPatientInHospital(patient2);
        hospital.addNewPatientInHospital(patient3);
        hospital.printAllDoctorsInHospital();
        hospital.printAllPatientsInHospital();
        
        System.out.println("\n-----------------------------");
        
        // Delete doctors and patients by their id
        System.out.println("DELETE DOCTOR AND PATIENT BY ID:");
        System.out.println("DELETE DOCTOR - Leonardo Da Vinci, AND PATIENT - Normunds Berzs\n");
        hospital.deleteExistingDoctorInHospitalById(1);
        hospital.deleteExistingPatientInHospitalById(1);
        hospital.printAllDoctorsInHospital();
        hospital.printAllPatientsInHospital();
        
        System.out.println("\n-----------------------------");
        
        // Delete doctors and patients by object
        System.out.println("ADDED NEW DOCTOR AND PATIENT");
        hospital.addNewDoctorInHospital(d4);
        hospital.addNewPatientInHospital(patient4);
        hospital.printAllDoctorsInHospital();
        hospital.printAllPatientsInHospital();
        System.out.println("\nDELETE DOCTOR AND PATIENT BY OBJECT:");
        System.out.println("DELETE DOCTOR - Maya Cloud, AND PATIENT - Baiba Karale");
        hospital.deleteExistingDoctorInHospitalByObject(d3);
        hospital.deleteExistingPatientInHospitalByObject(patient3);
        hospital.printAllDoctorsInHospital();
        hospital.printAllPatientsInHospital();
        
        System.out.println("\n-----------------------------");
        
        // Make a new appointment
        System.out.println("MAKE A NEW APPOINTMENT");
        hospital.makeNewAppointment(new Date(2019, 3, 19, 8, 15), "Heart Check", patient4, doctorListTest);
        hospital.makeNewAppointment(new Date(2019, 3, 19, 8, 30), "Heart Check", patient4, doctorListTest);
        hospital.printAllAppointmentsInHospital();
        System.out.println("MAKE A NEW APPOINTMENT IN SAME TIME");
        hospital.makeNewAppointment(new Date(2019, 3, 19, 8, 30), "Heart Check", patient4, doctorListTest);
    }
    
}
