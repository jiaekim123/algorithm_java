package harshad;

class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        int num = x, sum = 0;
        
		while (num / 10 != 0) {
			sum += num % 10;
			num = num / 10;
		}
		sum += num;
		
		if (x % sum != 0) answer = false;
        return answer;
    }
}

public class HarshadNumber {
	public static void main(String[] args) {
		System.out.println(new Solution().solution(10));
		System.out.println(new Solution().solution(12));
		System.out.println(new Solution().solution(11));
		System.out.println(new Solution().solution(9999));
	}
}
