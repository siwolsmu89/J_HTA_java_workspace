package map;

import java.util.ArrayList;
import java.util.HashMap;

public class HashMapDemo4 {
	public static void main(String[] args) {
		ArrayList<String> addresses = new ArrayList<String>();
		addresses.add("서울특별시 종로구 봉익동");
		addresses.add("경기도 부천시 원미구");
		addresses.add("경기도 수원시 권선구");
		addresses.add("서울특별시 서대문구 북가좌동");
		addresses.add("경기도 고양시");
		addresses.add("경상북도 구미시");
		addresses.add("경상남도 김해시");
		addresses.add("경상남도 창원시");
		addresses.add("경상남도 진주시");
		addresses.add("경상북도 영주시");
		addresses.add("경상북도 포항시");
		addresses.add("인천광역시 부평구");
		addresses.add("경기도 성남시");
		
		HashMap<String, Integer> result = new HashMap<String, Integer>();
	
		for (String addr : addresses) {
			int endPoint = addr.indexOf(" ");
			String sido = addr.substring(0, endPoint);

			if(result.containsKey(sido)) {
				int count = result.get(sido);
				result.put(sido, count+1);
			} else {
				result.put(sido, 1);
			}
			System.out.println(result);
		}
		
		
	
	}

}
