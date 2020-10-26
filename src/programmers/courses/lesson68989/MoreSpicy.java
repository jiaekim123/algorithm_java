package courses.lesson68989;

import java.util.Arrays;

class Solution {
	public int solution(int[] scoville, int K) {
		int answer = 0;
		while (true) {
			if ((scoville = mixScovile(scoville, K)) == null) {
				break;
			}
			answer++;
		}
		return answer;
	}

	private int[] mixScovile(int[] scoville, int K) {
		int[] newScoville = new int[scoville.length - 1];
		Arrays.sort(scoville);
		if (scoville[0] >= K) {
			return null;		
		}
		
		newScoville[0] = scoville[0] + (scoville[1] * 2);
		for (int i = 1; i < newScoville.length; i++) {
			newScoville[i] = scoville[i + 1];
		}
		return newScoville;
	}
}

public class MoreSpicy {
	public static void main(String[] args) {
		System.out.println(new Solution().solution(new int[] { 1, 2, 3, 9, 10, 12 }, 7));
	}
}
