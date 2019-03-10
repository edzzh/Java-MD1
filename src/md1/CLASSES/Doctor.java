package md1.CLASSES;

import md1.ENUMS.*;

/**
 *
 * @author Edgars Hartmanis 3ITB
 * Doctor class
 */
public class Doctor extends Person{
    private short officeNum;
    private int doctorId;
    static int doctorCounter;
    Speciality speciality;
    
    public Doctor(String name, String surname, int id, Gender gender, Nationality nationality, Speciality speciality, short officeNr) {
        super(name, surname, id, gender, nationality);
        this.speciality = speciality;
        this.officeNum = officeNr;
        this.doctorId = id;
        doctorCounter++;
    }
    
    public Speciality getSpeciality() {
        return speciality;
    }
    
    public void setSpeciality(Speciality speciality) {
        for (Speciality spec : Speciality.values()) {
            if (spec.equals(speciality)) {
                this.speciality = speciality;;
            }
        }
    }

    public short getOfficeNum() {
        return officeNum;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setOfficeNum(short officeNum) {
        if (officeNum > 0) {
            this.officeNum = officeNum;
        } else {
            System.out.println("Couldn't set Doctors office number, conditions didn't match");
        }
    }

    public void setDoctorId(int doctorId) {
        if (doctorId >= 0) {
            this.doctorId = doctorId;   
        } else {
            System.out.println("Couldn't set Doctors id, conditions didn't match");
        }
    }

    @Override
    public String toString() {
        return "Doctor{" + 
                "doctorName=" + getName() +
                ", doctorSurname=" + getSurname() +
                ", officeNum=" + officeNum + 
                ", doctorId=" + doctorId + 
                ", speciality=" + speciality + 
                ", gender=" +  gender +
                '}';
    }
}
