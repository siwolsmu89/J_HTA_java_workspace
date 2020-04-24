package bytestream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyDemo1 {

	public static void main(String[] args) throws IOException {
		// sample2.txt를 읽어오는 스트림
		FileInputStream fis = new FileInputStream("C:/files/sample2.txt");
		// sample3.txt에 기록하는 스트림
		FileOutputStream fos = new FileOutputStream("C:/files/sample3.txt");
		
		int value1 = fis.read();
		fos.write(value1);
		int value2 = fis.read();
		fos.write(value2);
		int value3 = fis.read();
		fos.write(value3);
		int value4 = fis.read();
		fos.write(value4);
		int value5 = fis.read();
		fos.write(value5);
		
		fis.close();
		fos.close();
		
		
	}
}
