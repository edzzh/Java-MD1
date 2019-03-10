package md1.CLASSES;

import md1.ENUMS.Gender;
import md1.ENUMS.Nationality;

/**
 *
 * @author Edgars Hartmanis 3ITB
 * Patient class
 */
public class Patient extends Person{
    private int patientId;
    static int patientCounter;
    private boolean isHospitalised;
    
    public Patient(String name, String surname, int id, Gender gender, Nationality nationality, boolean hospitalised) {
        super(name, surname, id, gender, nationality);
        this.isHospitalised = hospitalised;
        this.patientId = id;
        patientCounter++;
    }

    public int getPatientId() {
        return patientId;
    }

    public boolean isHospitalised() {
        return isHospitalised;
    }

    public void setPatientId(int patientId) {
        if (patientId >= 0) {
            this.patientId = patientId;   
        } else {
            System.out.println("Couldn't set Patient id, conditions didn't match");
        }
    }

    public void setHospitalised(boolean isHospitalised) {
        this.isHospitalised = isHospitalised;
    }

    @Override
    public String toString() {
        return "Patient{" + 
                "patientName=" + getName() + 
                ", patientSurname=" + getSurname() +
                ", patientId=" + patientId + 
                ", isHospitalised=" + isHospitalised + 
                '}';
    }
}
