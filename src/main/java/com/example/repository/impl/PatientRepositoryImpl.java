package com.example.repository.impl;

import com.example.domain.Patient;
import com.example.repository.PatientRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientRepositoryImpl implements PatientRepository {
    @Override
    public List<Patient> findAll() {
        try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {
            List<Patient> patients = new ArrayList<>();
            ResultSet rs = statement.executeQuery("select * from patient");
            while (rs.next()) {
                patients.add(
                        new Patient(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4))
                );
            }
            return patients;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Patient findById(Long id) {
        return null;
    }

    private Connection getConnection() throws SQLException {
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String username = "ehek01";
        String password = "ehek12";

        return DriverManager.getConnection(url, username, password);
    }
}
