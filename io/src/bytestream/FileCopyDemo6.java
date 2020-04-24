package bytestream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;

public class FileCopyDemo6 {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("c:/files/fastcampus_00_intro.pdf");
		FileOutputStream fos = new FileOutputStream("c:/files/fastcampus_00_intro_copy_2.pdf");
		
		IOUtils.copy(fis, fos);

	}
}
