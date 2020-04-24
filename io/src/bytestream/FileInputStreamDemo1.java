package bytestream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamDemo1 {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		FileInputStream fis = new FileInputStream("C:/files/sample.txt");
		
		int value1 = fis.read();
		int value2 = fis.read();
		int value3 = fis.read();
		
		System.out.println((char)value1);
		System.out.println((char)value2);
		System.out.println((char)value3);
		
		fis.close();
		
	}
}
