package ramda;

public class MyFunctionalInterfaceEx {

	public static void main(String[] args) {
		MyFunctionalInterface f1;
		
		f1 = (x, y) -> {
			return x+y;
		};
		int z = f1.method(10, 20);
		System.out.println(z);
	}

}
