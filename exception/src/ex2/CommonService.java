package ex2;

// 모든 서비스 클래스가 공통으로 사용하는 속성이나 기능을 정의한다.
public abstract class CommonService {

	public void processError(String errorCode, String msg) {
		throw new HTAException(errorCode, msg);
	}
	
}
