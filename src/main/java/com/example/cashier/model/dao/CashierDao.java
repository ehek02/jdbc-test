package com.example.cashier.model.dao;

import com.example.patient.model.dto.Patient;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CashierDao {

	private Connection getConnection() throws SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String username = "ehek01";
		String password = "ehek12";

		return DriverManager.getConnection(url, username, password);
	}

	public List<Patient> select() {
		String sql = "select * from patient";

		List<Patient> patients = new ArrayList<>();
		try {
			PreparedStatement pstmt = getConnection().prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();// select문에서는 executeQuery를 사용
			
			
			while (rs.next()) {
				patients.add(new Patient(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}//select문에서 사용

			// close
			//rs.close();
			pstmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return patients;

	}

//}
	public int insert(String resNo) {
		String patientCheck = "SELECT * "
				+			  "FROM PATIENT "
				+			  "WHERE PATIENT_NO = ?";
		
		
		String sql = "INSERT INTO RESERVATION"
				         + "( RESERVATION_NO"
				         + ", RESERVATION_DATE"
				         + ", PATIENT_ID)"
				   + "VALUES (RESERVATION_SEQ.NEXTVAL"
				   		 + ", SYSDATE"
				   		 + ", (SELECT PATIENT_ID "
				   		 +    "FROM PATIENT "
				   		 +    "WHERE PATIENT_NO = ?" 
						 +    ")"
				   + ")";
		
		
		System.out.println(sql);
		
		int rs = 0;
		ResultSet pcrs;
		
		List<Patient> patients = new ArrayList<>();
		try {
			PreparedStatement pstmt = getConnection().prepareStatement(patientCheck);
			
			//환자 id조회
			pstmt.setString(1, resNo);
			pcrs = pstmt.executeQuery();
			
			while (pcrs.next()) {
				patients.add(new Patient(pcrs.getLong(1), pcrs.getString(2), pcrs.getString(3), pcrs.getString(4)));
			}
			
			if(patients.size() != 0) {
				pstmt = getConnection().prepareStatement(sql);
				pstmt.setString(1, resNo);
				rs = pstmt.executeUpdate();
			}else {
				return patients.size();
			}

			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		return rs;

	}
}
