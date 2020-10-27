package courses.lesson68989;

import java.util.Arrays;

class Solution {
	public int solution(int[] scoville, int K) {
		int answer = 0;
		
		while (true) {
			Arrays.sort(scoville);
			int checkValue = checkScovile(scoville, K);
			if (checkValue == 1) break;
			else if (checkValue == -1) return -1;
			scoville = mixScovile(scoville, K);
			answer++;
		}
		return answer;
	}

	private int[] mixScovile(int[] scoville, int K) {
		int[] newScoville = new int[scoville.length - 1];
		newScoville[0] = scoville[0] + (scoville[1] * 2);
		for (int i = 1; i < newScoville.length; i++) {
			newScoville[i] = scoville[i + 1];
		}
		return newScoville;
	}
	
	// return // -1: 모든 원소를 K이상으로 할 수 없음 / 0: 다시 한번 더 믹스 / 1: 완료
	private int checkScovile(int[] scoville, int K) {
		if (scoville.length <= 1) return -1;
		if (scoville[0] >= K) {
			return 1;		
		}
		return 0;
		
	}
}

public class MoreSpicy {
	public static void main(String[] args) {
		System.out.println(new Solution().solution(new int[] { 1, 2, 3, 9, 10, 12 }, 7));
		System.out.println(new Solution().solution(new int[] { 1, 1, 1, 1, 1, 1}, 7));

	}
}
