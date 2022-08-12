package com.example.controller;

import com.example.repository.PatientRepository;
import com.example.repository.impl.PatientRepositoryImpl;

import java.util.Scanner;

public class PatientController {
    private final Scanner sc = new Scanner(System.in);
    private final PatientRepository patientRepository = new PatientRepositoryImpl();

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
                    confirmReservation();
                    break;
                case 3:
                    cancelReservation();
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

    private void createPatient() {

    }

    private void confirmReservation() {

    }

    private void cancelReservation() {

    }
}
