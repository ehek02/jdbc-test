package com.example.cashier.controller;

import com.example.cashier.service.CashierService;
import com.example.patient.model.dto.Patient;

import java.util.List;


public class CashierController {
	
	private final CashierService cashierService = new CashierService();
	
	
   //public int cashierService();
	
	public List<Patient> selectPatient(String resNo) { // 예약등록 메서드 int형으로 생성
		List<Patient> result = cashierService.selectPatient(resNo);
		//result 지역변수 선언해서 서비스에 있는 insertRservation에 resNo넣고 초기화
		return result; 
		// result 값 반환
	}
	
	public int registerReservation(String resNo) { // 예약등록 메서드 int형으로 생성
		int result = cashierService.insertReservation(resNo);
		//result 지역변수 선언해서 서비스에 있는 insertRservation에 resNo넣고 초기화
		return result; 
		// result 값 반환
	}
	
	
	

}
