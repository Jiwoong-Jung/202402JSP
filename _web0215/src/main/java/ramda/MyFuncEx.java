package ramda;

public class MyFuncEx {

	public static void main(String[] args) {
		MyFunc mf = () -> {
			System.out.println("람다");
			
		};
		mf.aaa();
		
		MyFunc mf1 = new MyFunc() {
			
			@Override
			public void aaa() {
				System.out.println("람다");
				
			}
		};
		mf1.aaa();
		

	}

}
