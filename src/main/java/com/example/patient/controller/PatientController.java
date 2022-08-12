package com.example.patient.controller;

import com.example.patient.model.dao.PatientDao;
import com.example.patient.model.dto.Patient;

import java.util.Scanner;

public class PatientController {
    private final PatientDao patientDao = new PatientDao();

    public int createPatient(Patient patient) {
        System.out.println("log : Controller에서 insert를 실행합니다.");
        return patientDao.insert(patient);
    }

    public void confirmReservation(String resNo) {
        Patient patient = patientDao.findByPatientNo(resNo);

        System.out.println("==========");
        System.out.println(patient.getPatientName() + "님 예약정보 입니다.");

        // TODO : 예약 테이블에서 환자번호로 컬럼 조회
    }

    public void cancelReservation(String resNo) {
        Patient patient = patientDao.findByPatientNo(resNo);
        System.out.println("==========");

        System.out.println(patient.getPatientName() + "님 예약정보 입니다.");

        System.out.print("삭제하시겠습니까?(y/n) : ");
        if (new Scanner(System.in).next().toLowerCase().charAt(0) == 'y') {
            // TODO : 예약 테이블에서 환자번호로 컬럼 삭제
        }
    }
}
