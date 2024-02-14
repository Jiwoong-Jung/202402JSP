package thread;

public class InterruptEx2 {

	public static void main(String[] args) {
		PrintThread3 printThread3 = new PrintThread3();
		printThread3.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		printThread3.interrupt();

	}

}
