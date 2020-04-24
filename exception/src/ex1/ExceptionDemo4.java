package ex1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class ExceptionDemo4 {

	public static void main(String[] args) {
		try {
			URL url = new URL("https://lh3.googleusercontent.com/proxy/p9A2JhAtDguPk1H8rq3JRZy6DSKl1_8ZTo6i76MIhu-PDBCOLImW79KNGNIrxQBffPDlr2YKAHntHLaz3C3EluvpzJZl1XDKuESXNNbiQxj3GOX3X04pvaTG-zcvd0lu-SSdJtlQNyiiE2FzyKr15eYHHg");
			InputStream in = url.openStream();

			FileOutputStream out = new FileOutputStream("c:/files/star.png");
			byte[] buf = new byte[1024];
			int len = 0;
			while((len=in.read(buf))!=-1) {
				out.write(buf,0,len);
			}
			out.close();
		} catch (MalformedURLException e) {
			//	e.printStackTrace();
			String errorMessage = e.getMessage();
			System.out.println("에러 메시지: " + errorMessage);
		} catch (FileNotFoundException e) {
			//	e.printStackTrace();
			String errorMessage = e.getMessage();
			System.out.println("에러 메시지: " + errorMessage);
		} catch (IOException e) {
			//	e.printStackTrace();
			String errorMessage = e.getMessage();
			System.out.println("에러 메시지: " + errorMessage);
			
		}
	}
}
