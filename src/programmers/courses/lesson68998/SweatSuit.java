package courses.lesson68998;

class Solution {
	public int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;

		// student의 체육복 상태를 저장하는 배열을 만든다.
		status[] students = new status[n];
		for (status student : students) {
			student = status.ONE;
		}
		for (int i = 0; i < reserve.length; i++) {
			students[reserve[i] - 1] = status.MORE;
		}

		// 체육복을 도둑맞아 없는 학생을 저장한다. 만약 많은 학생이 도둑맞았으면 ONE으로 변경한다.
		for (int i = 0; i < lost.length; i++) {
			if (students[lost[i] - 1] == status.MORE) {
				students[lost[i] - 1] = status.ONE;
			} else {
				students[lost[i] - 1] = status.NO;
			}
		}

		// 체육복을 빌려줄 수 있는 학생은 -1번째, +1번째 학생의 체육복이 없을 때 빌려준다.
		for (int i = 0; i < n; i++) {
			if (students[i] == status.MORE) {
				if (i > 0 && students[i - 1] == status.NO) {
					students[i] = status.ONE;
					students[i - 1] = status.ONE;
				} else if (i < n - 1 && students[i + 1] == status.NO) {
					students[i] = status.ONE;
					students[i + 1] = status.ONE;
				}
			}
		}

		// 체육복이 있는 학생의 수를 반환한다.
		for (status student : students) {
			if (student != status.NO)
				answer++;
		}
		return answer;
	}

	enum status {
		ONE, MORE, NO;
	}
}

public class SweatSuit {

	public static void main(String[] args) {
		System.out.println(new Solution().solution(5, new int[] { 2, 4 }, new int[] { 1, 3, 5 }));
		System.out.println(new Solution().solution(5, new int[] { 2, 4 }, new int[] { 3 }));
		System.out.println(new Solution().solution(3, new int[] { 3 }, new int[] { 1 }));
		System.out.println(new Solution().solution(2, new int[] { 1, 2 }, new int[] { 1 }));
		System.out.println(new Solution().solution(4, new int[] { 1, 3 }, new int[] { 2 }));
	}

}
