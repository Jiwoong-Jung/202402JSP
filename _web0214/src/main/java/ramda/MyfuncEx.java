package ramda;

public class MyfuncEx {

	public static void main(String[] args) {
		MyFunc mf;
		
		mf = new MyFunc() {
			@Override
			public void method() {
				System.out.println("method");
			}
		};
		mf.method();
	}

}
