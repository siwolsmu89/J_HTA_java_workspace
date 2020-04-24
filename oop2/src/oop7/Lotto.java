package oop7;

import java.util.Arrays;

public class Lotto {
	private int[] lottoNumbers = new int[6];
	private int position =0;

	// 전체공개된 메소드
	public int[] generateNumbers() {
		clearLottoNumbers();
		
		while(true) {
			int number = (int)(Math.random()*45+1);
			boolean duplicationChecked = isExist(number);
			if (!duplicationChecked) {
				lottoNumbers[position] = number;
				position++;
			}
			
			if(position==6) {
				break;
			}
		}
		
		Arrays.sort(lottoNumbers);
		
		return lottoNumbers;
	}
	
	// 내부적으로만 사용되는 메소드
	private void clearLottoNumbers() {
		for (int i=0;i<lottoNumbers.length;i++) {
			lottoNumbers[i]=0;
		}
		position=0;
	}
	
	// 내부적으로만 사용되는 메소드
	private boolean isExist(int number) {
		boolean result = false;
		
		for (int i=0; i<lottoNumbers.length;i++) {
			if(number == lottoNumbers[i]) {
				result=true;
				break;
			}
		}
		
		return result;
	}
	
}
