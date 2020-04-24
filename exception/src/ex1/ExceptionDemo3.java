package ex1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class ExceptionDemo3 {
	public static void main(String[] args) {
		
		try {
			URL url = new URL("https://lh3.googleusercontent.com/proxy/p9A2JhAtDguPk1H8rq3JRZy6DSKl1_8ZTo6i76MIhu-PDBCOLImW79KNGNIrxQBffPDlr2YKAHntHLaz3C3EluvpzJZl1XDKuESXNNbiQxj3GOX3X04pvaTG-zcvd0lu-SSdJtlQNyiiE2FzyKr15eYHHg");
			InputStream in = url.openStream();
			System.out.println("해당 인터넷 리소스와 연결을 시도합니다.");

			System.out.println("사진 저장을 시작합니다.");
			FileOutputStream out = new FileOutputStream("c:/files/star.png");
			byte[] buf = new byte[1024];
			int len = 0;
			while((len=in.read(buf))!=-1) {
				out.write(buf,0,len);
			}
			out.close();
			System.out.println("사진의 저장이 완료되었습니다.");
		} catch (MalformedURLException e) {
			System.out.println("올바른 URL이 아닙니다.");
		} catch (IOException e) {
			System.out.println("해당 인터넷 리소스를 읽어오는 중 오류가 발생했습니다.");
		} 
		
	}
}
