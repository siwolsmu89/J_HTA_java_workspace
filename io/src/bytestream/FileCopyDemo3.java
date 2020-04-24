package bytestream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyDemo3 {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream("C:/files/sarang.jpg");
		FileOutputStream fos = new FileOutputStream("C:/files/dog_copy.jpg");
		
		int value = 0;
		while ((value=fis.read()) != -1) {
			fos.write(value);
		}
		
		fis.close();
		fos.close();
	}
}
