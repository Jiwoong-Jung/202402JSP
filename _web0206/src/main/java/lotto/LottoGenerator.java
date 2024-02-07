package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class LottoGenerator {
    public static void main(String[] args) {
        // 무작위로 선택된 로또 번호를 담을 Set 생성
        Set<Integer> lottoNumbers = new HashSet<>();

        // 중복되지 않는 6개의 로또 번호를 선택
        Random random = new Random();
        while (lottoNumbers.size() < 6) {
            int number = random.nextInt(45) + 1; // 1부터 45까지의 숫자 중에서 무작위로 선택
            lottoNumbers.add(number);
        }

        // 선택된 로또 번호를 정렬하여 출력
        System.out.println("로또 번호: ");
        List<Integer> sortedNumbers = new ArrayList<>(lottoNumbers);
//        Collections.sort(sortedNumbers);
        for (int num : sortedNumbers) {
            System.out.print(num + " ");
        }
    }
}

