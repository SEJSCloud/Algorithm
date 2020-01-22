package algorithm;

public class LV1SecretMap {
	
//	���α׷��ӽ� LV1 ������� 2019 KAKAO BLIND RECRUITMENT
//	������ �� ���� ���̰� n�� ���簢�� �迭 ���·�, �� ĭ�� ����(" ) �Ǵº�(#") �� ������ �̷���� �ִ�.
//	��ü ������ �� ���� ������ ���ļ� ���� �� �ִ�. ���� ���� 1�� ���� 2��� ����. ���� 1 �Ǵ� ���� 2 �� ��� �ϳ��� ���� �κ��� ��ü ���������� ���̴�. ���� 1�� ���� 2���� ��� ������ �κ��� ��ü ���������� �����̴�.
//	���� 1�� ���� 2�� ���� ���� �迭�� ��ȣȭ�Ǿ� �ִ�.
//	��ȣȭ�� �迭�� ������ �� �����ٿ��� �� �κ��� 1, ���� �κ��� 0���� ��ȣȭ���� �� ������� �������� �ش��ϴ� ���� �迭�̴�.
	
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
