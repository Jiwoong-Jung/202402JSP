package sec03.exam03;

import java.io.File;

public class FileEx {

	public static void main(String[] args) {
		File dir = new File("c:/temp");
		File[] list = dir.listFiles();
		for (File file : list) {
			System.out.println(file);
		}

	}

}
