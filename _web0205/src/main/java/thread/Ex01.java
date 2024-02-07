package thread;

public class Ex01 {

	public static void main(String[] args) {
		System.out.println("시작");
		for (int i=0; i < 5; i++) {
			System.out.println("진행");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("끝");
	}

}
