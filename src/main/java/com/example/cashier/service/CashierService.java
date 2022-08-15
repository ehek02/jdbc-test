package com.example.cashier.service;

import com.example.cashier.model.dao.CashierDao;
import com.example.patient.model.dto.Patient;

import java.util.List;


public class CashierService {
	
	CashierDao cashierDao = new CashierDao();

	public List<Patient> selectPatient(String resNo) { //	문자형 iR 메서드 생성
		return cashierDao.select();
		// DAO에있는 insert 메서드에 resNo 넣고 반환
	}
	
	public int insertReservation(String resNo) { //	문자형 iR 메서드 생성
		
		return cashierDao.insert(resNo);
		// DAO에있는 insert 메서드에 resNo 넣고 반환
	}
	
	

}
