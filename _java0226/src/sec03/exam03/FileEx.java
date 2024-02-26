package sec03.exam03;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileEx {

	public static void main(String[] args) {
		File dir = new File("c:/temp");
		File[] list = dir.listFiles();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for (File file : list) {
			
			System.out.print(
					sdf.format(new Date(file.lastModified())) + "\t\t");
			System.out.println(file.getName());
		}

	}

}
