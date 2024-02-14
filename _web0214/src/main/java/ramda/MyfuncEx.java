package ramda;

public class MyfuncEx {

	public static void main(String[] args) {
		MyFunc mf, mf3;
		
		mf3 =(a) -> System.out.println(a);
		mf3.method(20);
		
		mf = new MyFunc() {
			
			@Override
			public void method(int x) {
				System.out.println(x);
			}
		};

		mf.method(10);
		

	}

}
