package ex1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionDemo1 {

	public static void main(String[] args) {
		
		try {
			// FileReader() 생성자 메소드는 fileNotFoundException 발생을 예고한다.
			FileReader reader = new FileReader("C:/setup.log");
			BufferedReader br = new BufferedReader(reader);
			
			// BufferedReader의 readLine() 메소드는 IOException 발생을 예고한다.
			String text = br.readLine();
			System.out.println("파일 내용: " + text);
		
			br.close();
		} catch (FileNotFoundException e) {
			// FileNotFoundException이 발생했을 때 실행되는 수행문을 작성한다.
			System.out.println("파일이 존재하지 않습니다. 파일명을 다시 확인하세요.");
		} catch (IOException e) {
			// IOException이 발생했을 때 실행되는 수행문을 발생한다.
			System.out.println("파일을 읽어오는 도중 오류가 발생하였습니다.");
		} 
		
	}
}
