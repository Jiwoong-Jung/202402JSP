package sec02.exam02;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
	public static void main(String[] args) {
		Queue<Message> messageQueue = new LinkedList<Message>();
		
		messageQueue.offer(new Message("sendMail", "홍길동"));
		messageQueue.offer(new Message("sendSMS", "신용권"));
		messageQueue.offer(new Message("sendKakaotalk", "홍두께"));
		
		while(!messageQueue.isEmpty()) {
			Message message = messageQueue.poll();
			switch(message.command) {
				case "sendMail":
					System.out.println(message.to + "님에게 메일 보냄.");
					break;
				case "sendSMS":
					System.out.println(message.to + "님에게 SMS 보냄.");
					break;
				case "sendKakaotalk": 
					System.out.println(message.to + "님에게 카카오톡 보냄.");
					break;
			}
		}
	}
}
