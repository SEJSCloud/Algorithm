package algorithm;

public class LV2TargetNumber {
	
//	n개의 음이 아닌 정수가 있습니다. 이 수를 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다. 예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.
//	-1+1+1+1+1 = 3
//	+1-1+1+1+1 = 3
//	+1+1-1+1+1 = 3
//	+1+1+1-1+1 = 3
//	+1+1+1+1-1 = 3
//	사용할 수 있는 숫자가 담긴 배열 numbers, 타겟 넘버 target이 매개변수로 주어질 때 숫자를 적절히 더하고 빼서 
//	타겟 넘버를 만드는 방법의 수를 return 하도록 solution 함수를 작성해주세요.
	
	public static int solution(int[] numbers, int target) {
		return dfs(numbers, 0, 0, target);
	}
	
	public static int dfs(int[] numbers, int node, int sum, int target) {
		if(node == numbers.length) {
			if(sum == target) {
				return 1;
			}
			return 0;
		}
		
		return dfs(numbers, node + 1, sum + numbers[node], target)
				+ dfs(numbers, node + 1, sum - numbers[node], target);
	}
	
	public static void main(String[] args) {
		int[] numbers = {1, 1, 1, 1, 3};
		int target = 3;
		System.out.println(solution(numbers, target));
		
	}
}
