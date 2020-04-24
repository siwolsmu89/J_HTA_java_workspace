package bytestream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.commons.io.IOUtils;

public class FileCopyDemo8 {

	public static void main(String[] args) throws IOException {
		
		URL url = new URL("https://github.com/");
		
		InputStream is = url.openStream();
		FileOutputStream fos = new FileOutputStream("C:/files/new.html");
		
		IOUtils.copy(is, fos);
	}
}
