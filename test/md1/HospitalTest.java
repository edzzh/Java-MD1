package md1;

import md1.CLASSES.*;
import md1.ENUMS.*;
import java.util.ArrayList;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author edgar
 */
public class HospitalTest { 
    // Mock Data
    Hospital h = new Hospital("Ventspils Slimnica");
    Doctor doctor = new Doctor("Bob", "Burger", 0, Gender.male, Nationality.Estonian, Speciality.Heart, (short)30);
    Patient patient = new Patient("Aija", "Celma", 0, Gender.female, Nationality.Latvian, true);
    
    ArrayList<Doctor> testDoctor = new ArrayList<>();
    ArrayList<Appointment> testAppointment = new ArrayList<>();
    ArrayList<Patient> testPatient = new ArrayList<>();
    
    Appointment appointment = new Appointment(new Date(2019, 3, 19, 8, 15), "Heart Check", patient, testDoctor);

    public HospitalTest() {}

    /**
     * Test of toString method, of class Hospital.
     */
    @Test
    public void testToString() {
        String actual = h.toString();
        String expected = "Hospital{hospitalName=Ventspils Slimnica}";
        assertEquals(expected, actual);
    }

    /**
     * Test of getDoctorsInHospital method, of class Hospital.
     */
    @Test
    public void testGetDoctorsInHospital() {
        testDoctor.add(doctor);
        h.addNewDoctorInHospital(doctor);
        assertEquals(testDoctor, h.getDoctorsInHospital());
    }

    /**
     * Test of setDoctorsInHospital method, of class Hospital.
     */
    @Test
    public void testSetDoctorsInHospital() {
        testDoctor.add(doctor);
        h.setDoctorsInHospital(testDoctor);
        assertEquals(testDoctor, h.getDoctorsInHospital());
    }

    /**
     * Test of getAppointmentsInHospital method, of class Hospital.
     * TODO - CHECK WTF HAPPING
     */
    @Test
    public void testGetAppointmentsInHospital() {
        assertEquals(testAppointment, h.getAppointmentsInHospital());
    }

    /**
     * Test of setAppointmentsInHospital method, of class Hospital.
     */
    @Test
    public void testSetAppointmentsInHospital() {
        testDoctor.add(doctor);
        testAppointment.add(appointment);
        h.setAppointmentsInHospital(testAppointment);
        assertEquals(testAppointment, h.getAppointmentsInHospital());
    }

    /**
     * Test of getPatientsInHospital method, of class Hospital.
     */
    @Test
    public void testGetPatientsInHospital() {
        testPatient.add(patient);
        h.addNewPatientInHospital(patient);
        assertEquals(testPatient, h.getPatientsInHospital());
    }

    /**
     * Test of setPatientsInHospital method, of class Hospital.
     */
    @Test
    public void testSetPatientsInHospital() {
        testPatient.add(patient);
        h.setPatientsInHospital(testPatient);
        assertEquals(testPatient, h.getPatientsInHospital());
    }

    /**
     * Test of getHospitalName method, of class Hospital.
     */
    @Test
    public void testGetHospitalName() {
        String actual = h.getHospitalName();
        String expected = "Ventspils Slimnica";
        assertEquals(expected, actual);
    }

    /**
     * Test of setHospitalName method, of class Hospital.
     */
    @Test
    public void testSetHospitalName() {
        h.setHospitalName("Test Slimnica");
        String expected = "Test Slimnica";
        assertEquals(expected, h.getHospitalName());
    }

    /**
     * Test of addNewPatientInHospital method, of class Hospital.
     */
    @Test
    public void testAddNewPatientInHospital() {
        testPatient.add(patient);
        h.addNewPatientInHospital(patient);
        assertEquals(testPatient, h.getPatientsInHospital());
    }

    /**
     * Test of deleteExistingPatientInHospitalById method, of class Hospital.
     */
    @Test
    public void testDeleteExistingPatientInHospitalById() {
        h.addNewPatientInHospital(patient);
        h.deleteExistingPatientInHospitalById(0);
        assertEquals(testPatient, h.getPatientsInHospital());
    }

    /**
     * Test of deleteExistingPatientInHospitalByObject method, of class Hospital.
     */
    @Test
    public void testDeleteExistingPatientInHospitalByObject() {
        h.addNewPatientInHospital(patient);
        h.deleteExistingPatientInHospitalByObject(patient);
        assertEquals(testPatient, h.getPatientsInHospital());
    }

    /**
     * Test of addNewDoctorInHospital method, of class Hospital.
     */
    @Test
    public void testAddNewDoctorInHospital() {
        testDoctor.add(doctor);
        h.addNewDoctorInHospital(doctor);
        assertEquals(testDoctor, h.getDoctorsInHospital());
    }

    /**
     * Test of deleteExistingDoctorInHospitalById method, of class Hospital.
     */
    @Test
    public void testDeleteExistingDoctorInHospitalById() {
        h.addNewDoctorInHospital(doctor);
        h.deleteExistingDoctorInHospitalById(0);
        assertEquals(testDoctor, h.getDoctorsInHospital());
    }

    /**
     * Test of deleteExistingDoctorInHospitalByObject method, of class Hospital.
     */
    @Test
    public void testDeleteExistingDoctorInHospitalByObject() {
        h.addNewDoctorInHospital(doctor);
        h.deleteExistingDoctorInHospitalByObject(doctor);
        assertEquals(testDoctor, h.getDoctorsInHospital());
    }

    /**
     * Test of makeNewAppointment method, of class Hospital.
     */
    @Test
    public void testMakeNewAppointment() {
        testDoctor.add(doctor);
        testAppointment.add(appointment);
        h.makeNewAppointment(new Date(2019, 3, 19, 8, 15), "Heart Check", patient, testDoctor);
        System.out.println(testAppointment.get(0));
        System.out.println(h.getAppointmentsInHospital().get(0));
    }

    /**
     * Test of deleteExistingAppointment method, of class Hospital.
     */
    @Test
    public void testDeleteExistingAppointment() {
        testDoctor.add(doctor);
        h.makeNewAppointment(new Date(2019, 3, 19, 8, 15), "Heart Check", patient, testDoctor);
        h.deleteExistingAppointment(patient, new Date(2019, 3, 19, 8, 15));
        assertEquals(testAppointment, h.getAppointmentsInHospital());
    }
}
