package com.example.cashier.view;

import java.util.List;
import java.util.Scanner;

import com.example.cashier.controller.CashierController;

public class CashierMenu {
	private final Scanner sc = new Scanner(System.in);
	private final CashierController cc = new CashierController();

	public void main() {
		while (true) {
			System.out.println("*** 수납원 페이지 ***\n1. 환자 예약 등록\n2. 환자 진료실 안내 \n3. 수납 비용 청구 " + 
					"\n0. 뒤로가기\n메뉴 번호 선택 : ");
			
			int menu = sc.nextInt();
			switch (menu) {
			case 1:
				registerReservation();
				break;
			case 2:
//				roomGuide();
				break;
			case 3:
//				clinicCost();
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
	
	private void registerReservation() {
		System.out.println("===== 예약 등록====="); //출력문
		System.out.println("예약자 주민번호 확인 : "); // 출력문
		String resNo = sc.next(); //입력한 값을 resNo에 저장 
		
		
		int rs = cc.registerReservation(resNo);
		
		if(rs > 0) {
			System.out.println("예약 등록 완료되었습니다.");
		}else {
			System.out.println("예약이 실패하였습니다.");
		}
		
		// 환자정보가 존재하는지
		//cc.registerReservation(resNo); //생성한 객체 cc로 컨트롤러의 메서드 rR에 resNo넣음
		
//		int result = cc.registerReservation(resNo); // 넣은 값을 a에 초기화
//		List<Patient> result = cc.selectPatient(resNo);
//		
//		if (result.size() != 0) {
//			for(int i = 0; i < result.size(); i++) {
//				System.out.println("등록된 환자 : " + result.get(i).getPatientName() + "입니다.");
//				
//			}
//		}else {
//			System.out.println("등록한 환자가 없습니다.");
//		}
		
		
	}

}
