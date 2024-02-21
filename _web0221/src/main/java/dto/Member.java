package dto;

public class Member {
	private String id;
	private String email;
	private String name;
	
	public Member(String id, String email, String name) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
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
		return "Member [id=" + id + ", email=" + email + ", name=" + name + "]";
	}
	
	
}
