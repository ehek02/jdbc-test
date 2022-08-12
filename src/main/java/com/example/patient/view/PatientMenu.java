package com.example.patient.view;

import com.example.patient.controller.PatientController;
import com.example.patient.model.dto.Patient;

import java.util.Scanner;

public class PatientMenu {
    private final Scanner sc = new Scanner(System.in);
    private final PatientController pc = new PatientController();

    public void main() {
        while (true) {
            System.out.print("*** 환자 페이지 ***\n1. 환자 정보 등록\n2. 예약 정보 확인\n3. 예약 취소" +
                    "\n0. 뒤로가기\n메뉴 번호 선택 : ");
            int menu = sc.nextInt();
            switch (menu) {
                case 1:
                    createPatient();
                    break;
                case 2:
                    confirmReserve();
                    break;
                case 3:
                    cancelReserve();
                    break;
                case 0:
                    System.out.println("프로그램 종료");
                    return;
                default:
                    System.out.println("올바른 메뉴번호를 선택하세요.");
                    break;
            }
        }
    }

    private void cancelReserve() {
        System.out.println("===== 예약 취소 =====");
        System.out.print("예약자 주민번호 입력 : ");
        String resNo = sc.next();
        pc.cancelReservation(resNo);
    }

    private void confirmReserve() {
        System.out.println("===== 예약 정보 확인 =====");
        System.out.print("예약자 주민번호 입력 : ");
        String resNo = sc.next();

        pc.confirmReservation(resNo);
    }

    private void createPatient() {
        System.out.println("===== 환자 정보 등록 =====");
        System.out.print("이름 입력 : ");
        String name = sc.next();
        System.out.print("주민번호 입력 : ");
        String resNo = sc.next();
        System.out.print("연락처 입력 : ");
        String phone = sc.next();

        Patient patient = new Patient(null, resNo, name, phone);

        int result = pc.createPatient(patient);

        if (result == 0) {
            System.out.println("환자정보 등록이 완료되었습니다.");
        }
    }
}
