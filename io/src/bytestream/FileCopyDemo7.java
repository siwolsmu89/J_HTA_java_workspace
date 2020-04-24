package bytestream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.commons.io.IOUtils;

public class FileCopyDemo7 {

	public static void main(String[] args) throws IOException {
		
		URL url = new URL("https://t1.daumcdn.net/cfile/tistory/991C68405E48B71A17");

		InputStream is = url.openStream();
		FileOutputStream fos = new FileOutputStream("c:/files/community_poster.jpg");
		
		IOUtils.copy(is, fos);
	}
}
