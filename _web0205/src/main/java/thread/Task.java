package thread;

public class Task implements Runnable {

	@Override
	public void run() {
		System.out.println("Task 시작");
		for (int i=0; i < 5; i++) {
			System.out.println("Task 진행");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Task 끝");
	}
}
