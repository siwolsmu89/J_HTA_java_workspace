package bytestream;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo1 {

	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("C:/files/sample2.txt");
		
		fos.write('h');
		fos.write('e');
		fos.write('l');
		fos.write('l');
		fos.write('o');
		fos.write(',');
		fos.write(' ');
		fos.write('j');
		fos.write('a');
		fos.write('v');
		fos.write('a');
		
		fos.close();
	}
}
