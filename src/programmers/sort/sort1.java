package sort;

import java.util.Arrays;

/**
 * 
 * Programmers - 정렬
 * K번째수
 * @author JIAE
 *
 */

class Solution {
	public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];

		for(int commNum = 0; commNum < commands.length; commNum++) {
			int[] cloneArray = new int[commands[commNum][1]-commands[commNum][0]+1];
			for(int i = commands[commNum][0]-1 ; i <commands[commNum][1]; i++) {
				cloneArray[i-commands[commNum][0]+1] = array[i];
			}
			Arrays.parallelSort(cloneArray);
			answer[commNum] = cloneArray[commands[commNum][2]-1];
		}
		return answer;
	}

}

public class sort1 {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] answer = solution.solution(
				new int[] {1, 5, 2, 6, 3, 7, 4}, 
				new int[][] {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});
		for(int num: answer) {
			System.out.print(num);
			System.out.print(" ");
		}
	}
}