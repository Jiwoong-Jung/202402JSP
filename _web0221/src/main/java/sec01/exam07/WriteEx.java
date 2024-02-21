package sec01.exam07;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriteEx {

	public static void main(String[] args) {
		try(Writer writer = new FileWriter("c:/temp/test7.txt")){
			char a = '가'; char b = '나'; char c = '다';
			writer.write(a); writer.write(b); writer.write(c);
		}catch(IOException e) {
			e.printStackTrace();
		}

	}

}
