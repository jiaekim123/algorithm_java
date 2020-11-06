package courses.lesson69001;

class Solution {
    public int solution(int[] money) {
    	return Math.max(includeFirstor(money), excludeFirst(money));
    }
    
    public int includeFirstor(int[] money) {
    	int max[] = new int[money.length];
    	max[0] = money[0];
    	max[1] = money[0];
    	for (int i = 2; i < money.length-1; i++) {
    		max[i] = Math.max(max[i-1], max[i-2] + money[i]);
    	}
    	return max[money.length-2];
    }
    
    public int excludeFirst(int[] money) {
    	int max[] = new int[money.length];
    	max[0] = 0;
    	max[1] = money[1];
    	for (int i = 2; i < money.length; i++) {
    		max[i] = Math.max(max[i-1], max[i-2] + money[i]);
    	}
    	return max[money.length-1];
    }
}

public class Stilling {
	public static void main(String[] args) {
		System.out.println(new Solution().solution(new int[]{1,2,3,1}));
	}
}
