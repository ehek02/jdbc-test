import com.example.domain.Patient;
import com.example.repository.PatientRepository;
import com.example.repository.impl.PatientRepositoryImpl;

import java.sql.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PatientRepository patientRepository = new PatientRepositoryImpl();

        List<Patient> patientList = patientRepository.findAll();

        for (Patient patient : patientList) {
            System.out.println(patient.toString());
        }
    }
}
