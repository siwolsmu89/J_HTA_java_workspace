package characterstream;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReaderDemo1 {

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader (new FileInputStream("c:/files/data.txt"), "MS949");
		BufferedReader br = new BufferedReader(isr);
		
		String text = "";
		while((text = br.readLine()) != null) {
			if(!text.isEmpty()) {
				System.out.println(text);
				String[] items = text.split(",");
				int price = Integer.parseInt(items[4]); // "28000" -> 28000
			}
		}
		
	}
}
