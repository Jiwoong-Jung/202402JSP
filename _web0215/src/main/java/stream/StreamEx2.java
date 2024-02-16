package stream;

public class StreamEx2 {

	public static void main(String[] args) {
//		String 에서 숫자를 추출하여 총 합(sum) 구하기
		String input = "1Ca2Adf9";
		int sum = input.chars()
		        .filter(Character::isDigit)  // 메서드 참조
		        .map(a -> Character.digit(a, 10))
		        .sum();

		System.out.println(sum); // 1 + 2 + 9

	}

}
