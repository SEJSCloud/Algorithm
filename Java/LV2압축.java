package algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LV2���� {
	
//	LZW ������ ���� ������ ��ģ��.
//
//	1. ���̰� 1�� ��� �ܾ �����ϵ��� ������ �ʱ�ȭ�Ѵ�.
//	2. �������� ���� �Է°� ��ġ�ϴ� ���� �� ���ڿ� w�� ã�´�.
//	3. w�� �ش��ϴ� ������ ���� ��ȣ�� ����ϰ�, �Է¿��� w�� �����Ѵ�.
//	4. �Է¿��� ó������ ���� ���� ���ڰ� �����ִٸ�(c), w+c�� �ش��ϴ� �ܾ ������ ����Ѵ�.
//	5. �ܰ� 2�� ���ư���.
	
	public int[] solution(String msg) {
		Queue<String> queue = new LinkedList<>();
		String[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");

		// �Ű������� ������ ���ڿ� �ɰ���
		String[] msgArray = msg.split("");

		// ������ �� ���� ����
		Stack<String> book = new Stack<>();

		// int�迭�� ����� ũ�⸦ ������� �ϴ� �������� �ؼ��ϱ� ����
		Stack<Integer> answerList = new Stack<>();
		String queueWord = null;
		String word = null;

		// å ����
		for (String alphabetElement : alphabet) {
			book.push(alphabetElement);
		}

		// ���ڿ��� ť�� ����ֱ�
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
