package algorithm;

public class LV1CaesarCipher {
	
//	���α׷��ӽ� LV1 ������ȣ
//	���� ����
//	� ������ �� ���ĺ��� ������ �Ÿ���ŭ �о �ٸ� ���ĺ����� �ٲٴ� ��ȣȭ ����� ���� ��ȣ��� �մϴ�. ���� ��� AB�� 1��ŭ �и� BC�� �ǰ�, 3��ŭ �и� DE�� �˴ϴ�. z�� 1��ŭ �и� a�� �˴ϴ�. ���ڿ� s�� �Ÿ� n�� �Է¹޾� s�� n��ŭ �� ��ȣ���� ����� �Լ�, solution�� �ϼ��� ������.
//
//	���� ����
//	������ �ƹ��� �о �����Դϴ�.
//	s�� ���ĺ� �ҹ���, �빮��, �������θ� �̷���� �ֽ��ϴ�.
//	s�� ���̴� 8000�����Դϴ�.
//	n�� 1 �̻�, 25������ �ڿ����Դϴ�.
	
//	s	n	result
//	AB	1	BC
//	z	1	a
//	a B z	4	e F d

	public String solution(String s, int n) {
		String answer = "";
		int codePoint = 0;
		
		for(int i = 0; i < s.length(); i++) {
			codePoint = s.codePointAt(i);
			
			if(codePoint == 32) {
				answer += " ";
			}else if(Character.isUpperCase(codePoint) && codePoint + n > 90 || Character.isLowerCase(codePoint) && codePoint + n > 122){
				answer += String.valueOf((char) (codePoint + n - 26));
			}else {
				answer += String.valueOf((char) (codePoint + n));
			}
		}
		
		return answer;
	}
}
