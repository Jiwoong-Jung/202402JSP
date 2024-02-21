package sec01.exam01;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadEx2 {

	public static void main(String[] args) {
		try (InputStream is 
				 = new FileInputStream("c:/temp/test2.db")) {
			byte[] buffer = new byte[100];
			while (true) {
				int cnt = is.read(buffer);
				if (cnt == -1) {
					break;
				}
				for (int i=0; i < cnt; i++) {
					System.out.println(buffer[i]);
				}
//				for (byte b : buffer) {
//					System.out.println(b);
//				}
			}
		} catch (IOException e) {
			
		}
		

	}

}
