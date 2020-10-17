package courses.lesson68972;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> answerList = new ArrayList<Integer>();
        for (int[] command : commands) {
        	int[] intArr = Arrays.copyOfRange(array, command[0]-1, command[1]);
        	Arrays.sort(intArr);
        	answerList.add(intArr[command[2]-1]);
        }
        int[] answer = new int[answerList.size()];
        for (int i = 0; i<answer.length; i++) {
        	answer[i] = answerList.get(i);
        }
        return answer;
    }
}

public class NumberK {
	public static void main(String[] args) {
		int[] answer = new Solution().solution(new int[] {1, 5, 2, 6, 3, 7, 4}, 
				new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});
		for (int num : answer) {
			System.out.print(num + " ");
		}
		System.out.println();
	}
}
