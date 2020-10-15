package kakaotest.test3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


class Result {

    /*
     * Complete the 'segment' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER x
     *  2. INTEGER_ARRAY space
     */

	// 1. 행의 시작부터 시작하여 특정 수의 컴퓨터에서 연속 세그먼트를 선택한다.
	// 2. 컴퓨터의 사용 가능한 하드 디스크 공간을 분석한다.
	// 3. 이 세그먼트 내에서 사용 가능한 최소 디스크 공간을 결정한다.
	// 첫번째 세그먼트 ~ 행의 끝까지 위 절차를 반복한다.
	// 세그먼트 크기가 4라면 1~4가 분석되고 다음 2~5가 분석된다.
	// 분석 중에 발견된 모든 최소 값 중에서 사용 가능한 최대 디스크 공간을 찾아라
	public static int segment(int x, List<Integer> space) {
		int[] minArr = new int[space.size() - x + 1];
		int[] spaceArr = listToArray(space);
		for (int start = 0; start <= space.size() - x; start++) {
			minArr[start] = findMinNumber(spaceArr, start, start + x - 1);
		}
		
		// 최소 값 중 사용 가능한 최대 디스크 공간을 찾는다.
		Arrays.sort(minArr);
		return minArr[minArr.length - 1];
	}

	// arr의 start~end 사이에 가장 작은 숫자를 찾는다.
	
	private static int findMinNumber(int[] space, int start, int end) {
		int min = Integer.MAX_VALUE;
		for (int i = start; i <= end; i++) {
			if (space[i] < min) min = space[i];
		}
		return min;
	}
	
	// 속도 개선을 위해 list를 arr로 변경한다.
	private static int[] listToArray(List<Integer> arr) {
		int[] array = new int[arr.size()];
		for (int i = 0 ; i<arr.size(); i++) {
			array[i] = arr.get(i);
		}
		return array;
	}

}

public class Test3 {
	public static void main(String[] args) {
		System.out.println(Result.segment(2, Arrays.asList(8,2,4)));
		System.out.println(Result.segment(1, Arrays.asList(1,2,3,1,2)));
		System.out.println(Result.segment(2, Arrays.asList(1,1,1)));
	}
}
