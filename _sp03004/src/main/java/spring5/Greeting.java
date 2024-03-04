package spring5;

public class Greeting {
    public String getMessage(int hour) {
        String message;
        if (hour >= 17 || hour < 5) {
            message = "수고 많으십니다";
        } else if (hour < 11) {
            message = "좋은 아침입니다";
        } else {
            message = "안녕하십니까";
        }
        return message;
    }

}
