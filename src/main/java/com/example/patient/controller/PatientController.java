package com.example.patient.controller;

import com.example.patient.model.dao.PatientDao;
import com.example.patient.model.dto.Patient;

public class PatientController {
    private final PatientDao patientDao = new PatientDao();

    public int createPatient(Patient patient) {
        System.out.println("log : Controller에서 insert를 실행합니다.");
        return patientDao.insert(patient);
    }

    public void confirmReservation() {

    }

    public void cancelReservation() {

    }

    public void selectAll() {

    }
}
