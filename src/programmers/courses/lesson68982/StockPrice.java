package courses.lesson68982;

import java.util.Arrays;

class Solution {
	public int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
		boolean[] isIncrease = new boolean[prices.length];
		Arrays.fill(isIncrease, true);

		for (int i = 0; i < prices.length; i++) {
			answer[i] = 0;
			for (int j = i - 1; j >= 0; j--) {
				if (isIncrease[j]) {
					answer[j]++;
					if (prices[i] < prices[j]) {
						isIncrease[j] = false;
					}
				}
			}
		}

		return answer;
	}
}

public class StockPrice {
	public static void main(String[] args) {
		for (int price : new Solution().solution(new int[] { 1, 2, 3, 2, 3 })) {
			System.out.print(price + " ");
		}
	}
}
