package algorithm;

public class LV2Expression {
	  public int solution(int n) {
	      int answer = 0;
	      int count = 0;
	      int num = 2;
	      
	      for(int i = 1; i <= n; i++){
	          count += i;    
	          if (count > n){
	              count = 0;
	              i = num;
	              num++;
	          } else if (count == n){
	              count = 0;
	              answer++;
	              i = num;
	              num++;
	          }
	      }
	      return answer;
	  }
}
