package ex2;

import java.util.HashMap;
import java.util.Map;

public class ErrorCode {

	private Map<String, String> errorCodes = new HashMap<String, String>();
	
	public ErrorCode() {
		errorCodes.put("ERROR_USER_001", "아이디가 중복되었습니다.");
		errorCodes.put("ERROR_USER_002", "가입되지 않은 아이디입니다.");
		errorCodes.put("ERROR_USER_003", "비밀번호가 존재하지 않습니다.");
		errorCodes.put("ERROR_USER_004", "부적절한 아이디입니다.");
		errorCodes.put("ERROR_USER_005", "완전하지 못한 비밀번호 조합입니다.");
	}
	
	public String getDescription(String errorCode) {
		return errorCodes.get(errorCode);
	}
}
