package sec01.verify.exam02;

public class ThreadEx {

	public static void main(String[] args) {
		Thread th1 = new MovieThread();
		th1.start();
		
		Thread th2 = new Thread(new MusicRunnable());
		th2.setName("Music");
		th2.start();
	}

}
