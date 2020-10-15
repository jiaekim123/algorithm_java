package kakaotest.test2;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Result {

    /*
     * Complete the 'requestsServed' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY timestamp
     *  2. INTEGER_ARRAY top
     */

	// timestamp : 요청이 도착하는 시간 배열
	// top: 서버가 우선순위를 갖는 시간 배열
	public static int requestsServed(List<Integer> timestamp, List<Integer> top) {
		
		// 1. timestamp를 넣을 스택 생성
		Stack<Integer> requestStack = new Stack<Integer>();
		for (int request : timestamp) {
			requestStack.add(request);
		}

		// 2. timestamp에서 top[i]보다 크지 않은 애들을 맨 마지막애부터 5개 스택에서 제거함 (FILO)
		for (int max : top) {
			int count = 1;
			boolean isEnd = false;

			while (count <= 5 && !isEnd) {
				for (int j = requestStack.size() - 1; j >= 0 && count <= 5; j--) {
					if (requestStack.elementAt(j) <= max) {
						requestStack.remove(j);
						count++;
					}
					if (j == 0 || j == (timestamp.size() - (top.size() * 5)))
						isEnd = true;
				}
			}
		}

		// 3. timestamp의 길이 - 스택의 길이 return
		return timestamp.size() - requestStack.size();
	}
    
}

public class Test2 {
	public static void main(String[] args) {
		System.out.println(new Result().requestsServed(Arrays.asList(0,1,1,2,4,5), Arrays.asList(5)));
		System.out.println(new Result().requestsServed(Arrays.asList(1,2,2,3,4,5,6,6,13,16), Arrays.asList(10,15)));
		System.out.println(new Result().requestsServed(Arrays.asList(27,2,55,17,31,5,58,43,15,20,33,57,4,34,28,4,55,29,37,30,2,43,29,18,44)
				, Arrays.asList(44,7,21,20,34)));
	}
	
}
