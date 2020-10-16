package courses.lesson68971;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        List<int[]> numList = getNumList(nums);
        
        for (int[] numArr : numList) {
        	for (int i = 0; i <numArr.length; i++) {
        		System.out.print(numArr[i] + " ");
        	}
        	System.out.println();
        	if (isPrimeNum(numArr)) answer++;
        }
        
        return answer;
    }
    private List<int[]> getNumList(int[] nums) {
    	List<int[]> numList = new ArrayList<int[]>();
    	boolean[] visited = new boolean[nums.length];
//    	combination(nums, numList, visited, 0, nums.length, 3);
//    	System.out.println(numList);
    	return numList;
    }
    
    private boolean isPrimeNum(int[] numArr) {
    	int primeNum = 0;
    	for (int num: numArr) {
    		primeNum += num;
    	}
    	System.out.println(primeNum);
    	if (primeNum == 0 || primeNum == 1) return false;
    	else if (primeNum == 2) return true;
    	
    	for (int i=2; i<primeNum; i++) {
    		if(primeNum%i==0) return false;
    	}
    	
    	return true;
    }
    
}

public class MinorityNum {

	public static void main(String[] args) {
		System.out.println(new Solution().solution(new int[] {1,2,3,4}));
	}

}
