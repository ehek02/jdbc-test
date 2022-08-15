package com.example.patient.service;

import com.example.patient.model.dao.PatientDao;
import com.example.patient.model.dto.Patient;
import com.example.patient.model.dto.Reservation;

import java.sql.PreparedStatement;
import java.util.Scanner;

public class PatientService {
    PatientDao patientDao = new PatientDao();

    // 환자 등록
    public int createPatient(Patient patient) {
        return patientDao.insert(patient);
    }

    // 예약 확인
    public Reservation checkReservation(String resNo) {
        Patient patient = patientDao.findByPatientNo(resNo);
        if (patient == null) {
            System.out.println("log warning : 등록된 환자가 없습니다.");
            return null;
        }

        return patientDao.findReservationByPatientNo(resNo);
    }

    // 예약 취소
    public int deleteReserve(String resNo) {
        Patient patient = patientDao.findByPatientNo(resNo);
        if (patient == null) {
            System.out.println("log warning : 등록된 환자가 없습니다.");
            return 1;
        }

        // TODO : 예약DAO에서 주민번호로 DTO 가져온다음 null이 아니면 삭제
        System.out.print("삭제하시겠습니까?(y/n) : ");
        if (new Scanner(System.in).next().toLowerCase().charAt(0) == 'y') {
            return patientDao.deleteReservation(patient.getPatientId());
        }

        return 1;
    }

    public Patient findPatientByPatientNo(String resNo) {
        return patientDao.findByPatientNo(resNo);
    }
}