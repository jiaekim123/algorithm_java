package dfs;

class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }
    
    private int dfs(int[] numbers, int target, int index, int num) {
    	if (index == numbers.length) {
    		return num == target ? 1 : 0;
    	} else {
    		return dfs(numbers, target, index + 1, num + numbers[index])
    				+ dfs(numbers, target, index + 1, num - numbers[index]);
    	}
    }
}

public class TargetNumber {
	public static void main(String[] args) {
		System.out.println(new Solution().solution(new int[]{1,1,1,1,1}, 3));
	}
}
