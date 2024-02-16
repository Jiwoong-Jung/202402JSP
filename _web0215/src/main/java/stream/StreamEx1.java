package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamEx1 {

	public static void main(String[] args) {
		List<Integer> list 
		          = Arrays.asList(1, 2, 3, 4, 5);
//			= new ArrayList<>();
//		list.add(1);list.add(2);
//		list.add(3);list.add(4);list.add(5);
		for (Integer i : list) {
		    if (i % 2 == 0) { // 2의 배수 추출
		        System.out.println(i);
		    }
		}

	}

}
