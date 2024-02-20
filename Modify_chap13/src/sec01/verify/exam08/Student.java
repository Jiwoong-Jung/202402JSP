package sec01.verify.exam08;

public class Student {
	public int studentNum;
	public String name;
	
	public Student (int studentNum, String name) {
		this.studentNum = studentNum;
		this.name = name;
	}
	
	@Override
	public int hashCode() {
//		return studentNum;
		return name.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Student)) return false;
		Student student = (Student) obj;
//		if(studentNum != student.studentNum) return false;
		if(!name.equals(student.name)) return false;
		return true;
	}
}
