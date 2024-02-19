package collections;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

import dao.MemberDao;
import dto.Member;

public class HashMapEx2 {

	public static void main(String[] args) {
		MemberDao dao = MemberDao.getInstance();
		HashMap<String, Member> map = dao.selectMembers();
		
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("아이디와 비밀번호 입력");
			System.out.print("아이디: " );
			String id = scanner.nextLine();
			System.out.print("이메일: " );
			String email = scanner.nextLine();
			System.out.println();
			
			if (map.containsKey(id)) { // 좋은 메소드
				if (map.get(id).getEmail().equals(email)) {
					System.out.println("로그인됨");
					break;
				} else {
					System.out.println("비밀번호 오류");
				}
			} else {
				System.out.println("입력한 아이디가 존재 안함");
			}
			
		}
	}

}
