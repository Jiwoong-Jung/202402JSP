package thread;

public class Ex03 {

	public static void main(String[] args) {
		Thread th = new Thread(new Runnable() {
			
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
		});
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
