package ramda;

public class MyfuncEx {

	public static void main(String[] args) {
		MyFunc mf, mf3;
		
		mf3 = x -> {
			System.out.println(x);
		};
		
		mf = new MyFunc() {  // 익명 객체 생성
			
			@Override
			public void method(int x) {
				System.out.println(x);
			}
		};

		mf.method(10);
		

	}

}
