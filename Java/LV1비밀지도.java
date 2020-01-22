package algorithm;

public class LV1SecretMap {
	
//	프로그래머스 LV1 비밀지도 2019 KAKAO BLIND RECRUITMENT
//	지도는 한 변의 길이가 n인 정사각형 배열 형태로, 각 칸은 공백(" ) 또는벽(#") 두 종류로 이루어져 있다.
//	전체 지도는 두 장의 지도를 겹쳐서 얻을 수 있다. 각각 지도 1과 지도 2라고 하자. 지도 1 또는 지도 2 중 어느 하나라도 벽인 부분은 전체 지도에서도 벽이다. 지도 1과 지도 2에서 모두 공백인 부분은 전체 지도에서도 공백이다.
//	지도 1과 지도 2는 각각 정수 배열로 암호화되어 있다.
//	암호화된 배열은 지도의 각 가로줄에서 벽 부분을 1, 공백 부분을 0으로 부호화했을 때 얻어지는 이진수에 해당하는 값의 배열이다.
	
	  public String[] solution(int n, int[] arr1, int[] arr2) {
	      String[] answer = new String[n];
	      String[] arr1ToString = changeToBinaryscale(n, arr1);
	      String[] arr2ToString = changeToBinaryscale(n, arr2);
	      
	      for(int i = 0; i < n; i++) {
	    	  answer[i] = "";
	    	  
	    	  for(int j = 0; j < n; j++) {
	    		  if(arr1ToString[i].charAt(j) == '1' || arr2ToString[i].charAt(j) == '1') {
	    			  answer[i] += "#";
	    		  }else {
	    			  answer[i] += " ";
	    		  }
	    		  
	    	  }
	      }
	      
	      return answer;
	  }
	  
	  public String[] changeToBinaryscale(int n, int[] arr) {
		  String[] arrToString = new String[n];
	      int power = 0;
	      
	      for(int i = 0; i < n; i++) {
	    	  arrToString[i] = "";
	    	  power = n - 1;
	    	  
	    	  while(power != -1) {
	    		  double value = Math.pow(2, power);
	    		  
	    		  if(arr[i] >= value) {
		    		  arrToString[i] += 1;
		    		  arr[i] -= value;
	    		  }else {
	    			  arrToString[i] += 0;
	    		  }
	    		  
	    		  power--;
	    	  }
	      }
	      
	      return arrToString;
	  }
}
