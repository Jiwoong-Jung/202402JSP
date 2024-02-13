package sec01.verify.exam02;

public class ThreadEx {

	public static void main(String[] args) {
		Thread mth = Thread.currentThread();
		System.out.println(mth.getName());
		
		Thread th1 = new MovieThread();
		System.out.println(th1.getName());
		th1.start();
		
		Thread th2 = new Thread(new MusicRunnable());
		th2.setName("Music");
		System.out.println(th2.getName());
		th2.start();
	}

}
