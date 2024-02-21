package sec01.exam01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteEx {

	public static void main(String[] args) {
		try (OutputStream os 
				   = new FileOutputStream("c:/temp/test1.db")) {
			byte a = 10; byte b = 20; byte c = 30;
			os.write(a); os.write(b); os.write(c);
			os.flush();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
