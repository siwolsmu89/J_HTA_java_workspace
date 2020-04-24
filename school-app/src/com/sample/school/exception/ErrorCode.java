package com.sample.school.exception;

import java.util.HashMap;
import java.util.Map;

public class ErrorCode {

private Map<String, String> errorCodes = new HashMap<String, String>();
	
	public ErrorCode() {
		errorCodes.put("ERROR_000", "원인을 알 수 없는 오류가 발생했습니다.");
		errorCodes.put("ERROR_001", "해당 항목에 입력된 정보가 없습니다.");
		errorCodes.put("ERROR_002", "입력하신 값들이 일치하지 않습니다.");
		errorCodes.put("ERROR_003", "잘못된 입력값입니다.");
		
		errorCodes.put("ERROR_PROF_01", "일치하는 교수님의 정보가 없습니다.");
		errorCodes.put("ERROR_PROF_02", "메일 주소가 동일한 교수님이 존재합니다.");
		
		errorCodes.put("ERROR_SUBJ_01", "일치하는 과목 정보가 없습니다.");
		errorCodes.put("ERROR_SUBJ_02", "이미 개설된 과목명입니다.");
		
		errorCodes.put("ERROR_COUR_01", "일치하는 과정 정보가 없습니다.");
		errorCodes.put("ERROR_COUR_02", "등록된 과정 정보가 없습니다.");
		errorCodes.put("ERROR_COUR_03", "신청이 마감된 과정입니다.");
		
		errorCodes.put("ERROR_RGST_01", "일치하는 등록 정보가 없습니다.");
		errorCodes.put("ERROR_RGST_02", "과정을 신청한 학생이 없습니다.");
		errorCodes.put("ERROR_RGST_03", "신청을 취소한 학생입니다.");

		errorCodes.put("ERROR_DEPT_01", "일치하는 학과 정보가 없습니다.");

		errorCodes.put("ERROR_STUD_01", "일치하는 학생 정보가 없습니다.");
		errorCodes.put("ERROR_STUD_02", "메일 주소가 동일한 학생이 존재합니다.");
	}
	
	public String getDescription(String errorCode) {
		return errorCodes.get(errorCode);
	}
}
