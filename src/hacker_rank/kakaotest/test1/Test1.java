package kakaotest.test1;

import java.util.Arrays;
import java.util.List;

class Result {

    /*
     * Complete the 'splitIntoTwo' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

	public static int splitIntoTwo(List<Integer> arr) {
		int answer = 0;
		int[] intArr = listToArray(arr);
		int totalSum = calculateArrSum(intArr, 0, arr.size()-1);
		for (int i = 0; i < arr.size() - 1; i++) {
			int left = calculateArrSum(intArr, 0, i);
			if (left > totalSum - left) {
				answer++;				
			}
		}
		return answer;
	}
	
	private static int calculateArrSum(int[] arr, int start, int end) {
		int sum = 0;
		for (int i = start; i<=end; i++) {
			sum += arr[i];
		}
		return sum;
	}
	
	private static int[] listToArray(List<Integer> arr) {
		int[] array = new int[arr.size()];
		for (int i = 0 ; i<arr.size(); i++) {
			array[i] = arr.get(i);
		}
		return array;
	}

}
public class Test1 {

	public static void main(String[] args) {
		System.out.println(Result.splitIntoTwo(Arrays.asList(10,4,-8,7)));
	}

}
