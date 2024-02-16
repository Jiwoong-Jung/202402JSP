package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamEx1 {

	public static void main(String[] args) {
		List<Integer> list 
		          = Arrays.asList(1, 2, 3, 4, 5);
		list
		.stream()
//		.filter(i->i%2==0)
//		.map(i->i*2)
		.map(i -> "요소는" + i + "입니다.")
		.limit(3)
//		.forEach(i->System.out.println(i));
		.forEach(System.out::println);
		
//		List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
//		Stream<Integer> stream = integerList.stream(); // Stream 생성
//		Stream<Integer> stream2 = stream.filter(i -> i % 2 == 0); // 중간 연산
//		stream2.forEach(i -> System.out.println(i)); // 최종 연산
		
		
		
//			= new ArrayList<>();
//		list.add(1);list.add(2);
//		list.add(3);list.add(4);list.add(5);
//		for (Integer i : list) {
//		    if (i % 2 == 0) { // 2의 배수 추출
//		        System.out.println(i);
//		    }
//		}

	}

}
