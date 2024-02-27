package mvjsp.board.model;

public class Member {
	int memberno;
	String id;
	String email;
	String name;
	public Member(int memberno, String id, String email, String name) {
		super();
		this.memberno = memberno;
		this.id = id;
		this.email = email;
		this.name = name;
	}
	public int getMemberno() {
		return memberno;
	}
	public void setMemberno(int memberno) {
		this.memberno = memberno;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Member [memberno=" + memberno + ", id=" + id + ", email=" + email + ", name=" + name + "]";
	}

	
	
}

