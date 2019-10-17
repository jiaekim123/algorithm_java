package bruteforce;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Programmers - 완전탐색 모의고사
 * 
 * @author JIAE
 *
 */

class Solution {
	private int[] studentA, studentB, studentC;
	private int length;

	public int[] solution(int[] answers) {
		length = answers.length;
		studentA = new int[length];
		studentB = new int[length];
		studentC = new int[length];

		/** Fill student's answer **/
		fillStudentAnswer();

		int[] score = scoreStudentAnswer(answers);

		int max = score[0]; // max score
		if (max < score[1]) {
			max = score[1];
		}
		if (max < score[2]) {
			max = score[2];
		}

		ArrayList<Integer> array = new ArrayList<Integer>();
		for (int i = 0; i < 3; i++) {
			if (score[i] == max) {
				array.add(i + 1);
			}
		}

		Integer[] integerAnswer = array.toArray(new Integer[array.size()]);
		Arrays.parallelSort(integerAnswer);

		int[] answer = new int[integerAnswer.length];
		for (int i = 0; i < integerAnswer.length; i++) {
			answer[i] = integerAnswer[i];
		}

		return answer;
	}

	private int[] scoreStudentAnswer(int[] answers) {
		int[] score = { 0, 0, 0 };
		for (int i = 0; i < length; i++) {
			if (studentA[i] == answers[i]) {
				score[0] = score[0] + 1;
			}
			if (studentB[i] == answers[i]) {
				score[1] = score[1] + 1;
			}
			if (studentC[i] == answers[i]) {
				score[2] = score[2] + 1;
			}
		}
		return score;
	}

	private void fillStudentAnswer() {
		for (int i = 0; i < length; i++) {
			/* student A */
			studentA[i] = i % 5 + 1;

			/* student B */
			if ((i + 1) % 2 == 1) {
				studentB[i] = 2;
			} else if ((i + 1) % 8 == 2) {
				studentB[i] = 1;
			} else if ((i + 1) % 8 == 4) {
				studentB[i] = 3;
			} else if ((i + 1) % 8 == 6) {
				studentB[i] = 4;
			} else {
				studentB[i] = 5;
			}

			/* student C */
			if ((i + 1) % 10 == 1 || (i + 1) % 10 == 2) {
				studentC[i] = 3;
			} else if ((i + 1) % 10 == 3 || (i + 1) % 10 == 4) {
				studentC[i] = 1;
			} else if ((i + 1) % 10 == 5 || (i + 1) % 10 == 6) {
				studentC[i] = 2;
			} else if ((i + 1) % 10 == 7 || (i + 1) % 10 == 8) {
				studentC[i] = 4;
			} else {
				studentC[i] = 5;
			}
		}
	}

}

public class bruteforce {
	public static void main(String[] args) {
		int[] answers = { 1, 2, 3, 4, 5 };
		Solution solution = new Solution();
		int[] result = solution.solution(answers);
		System.out.println(Arrays.toString(result));

	}
}