package sec01.exam01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteEx2 {

	public static void main(String[] args) {
		try (OutputStream os 
				   = new FileOutputStream("c:/temp/test3.db")) {
			byte[] array = {10, 20, 30, 40, 50};
			os.write(array, 1, 3);
			os.flush();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
