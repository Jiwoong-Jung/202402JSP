package thread;

public class Ex02 {

	public static void main(String[] args) {
		Task task = new Task();
		Thread th = new Thread(task);
		th.start();
		mainTask();
	}
	public static void mainTask() {
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
