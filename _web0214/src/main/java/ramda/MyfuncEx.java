package ramda;

public class MyfuncEx {

	public static void main(String[] args) {
		MyFunc mf, mf2;
		
		mf = new MyFunc() {
			@Override
			public void method() {
				System.out.println("method");
			}
		};
		mf.method();
		
		mf2 = () -> {System.out.println("method");};
		mf2.method();
	}

}
