package algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LV2압축 {
	
//	LZW 압축은 다음 과정을 거친다.
//
//	1. 길이가 1인 모든 단어를 포함하도록 사전을 초기화한다.
//	2. 사전에서 현재 입력과 일치하는 가장 긴 문자열 w를 찾는다.
//	3. w에 해당하는 사전의 색인 번호를 출력하고, 입력에서 w를 제거한다.
//	4. 입력에서 처리되지 않은 다음 글자가 남아있다면(c), w+c에 해당하는 단어를 사전에 등록한다.
//	5. 단계 2로 돌아간다.
	
	public int[] solution(String msg) {
		Queue<String> queue = new LinkedList<>();
		String[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");

		// 매개변수로 들어오는 문자열 쪼개기
		String[] msgArray = msg.split("");

		// 사전이 될 변수 선언
		Stack<String> book = new Stack<>();

		// int배열로 선언시 크기를 맞춰줘야 하는 불편함을 해소하기 위해
		Stack<Integer> answerList = new Stack<>();
		String queueWord = null;
		String word = null;

		// 책 생성
		for (String alphabetElement : alphabet) {
			book.push(alphabetElement);
		}

		// 문자열을 큐에 담아주기
		for (String msgElement : msgArray) {
			queue.offer(msgElement);
		}
		while (!queue.isEmpty()) {
			word = "";
			while (true) {
				queueWord = queue.peek();
				if (book.contains(word + queueWord)) {
					word += queue.poll();
				} else {
					answerList.push(book.indexOf(word) + 1);
					if (queueWord != null) {
						book.push(word + queueWord);
					}
					break;
				}
			}
		}
		return answerList.stream().mapToInt(s -> s).toArray();
	}
}
