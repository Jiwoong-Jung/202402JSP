package drive;

import dao.MemberDao;
import dto.Member;

public class MemberDaoEx {

	public static void main(String[] args) {
		MemberDao dao = MemberDao.getInstance();
		Member member = dao.select("admin");
		System.out.println(member);

	}

}
