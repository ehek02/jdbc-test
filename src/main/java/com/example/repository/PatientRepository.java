package com.example.repository;

import com.example.domain.Patient;

import java.util.List;

public interface PatientRepository {
    List<Patient> findAll();

    Patient findById(Long id);


}
