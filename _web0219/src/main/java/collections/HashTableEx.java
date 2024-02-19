package collections;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class HashTableEx {

	public static void main(String[] args) {
		Map<String, String> map = new Hashtable<>();
		
		map.put("spring", "12");
		map.put("summer", "123");
		map.put("fall", "1234");
		map.put("winter", "12345");
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("아이디와 비밀번호 입력");
			System.out.print("아이디: " );
			String id = scanner.nextLine();
			System.out.print("비밀번호: " );
			String password = scanner.nextLine();
			System.out.println();
			
//			if (map.containsKey(id)) { // 좋은 메소드
			String str = map.get(id);
				if (str != null && str.equals(password)) {
					System.out.println("로그인됨");
					break;
				} else {
					System.out.println("비밀번호 오류");
				}
//			} else {
//				System.out.println("입력한 아이디가 존재 안함");
//			}
			
		}
	}

}
