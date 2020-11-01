package courses.lesson68989;

import java.util.PriorityQueue;

class Solution {
	public int solution(int[] scoville, int K) {
		PriorityQueue<Integer> scovilleQueue = new PriorityQueue<Integer>();
		for (int num : scoville) {
			scovilleQueue.offer(num);
		}
		
		return mixScovile(scovilleQueue, K);
	}

	private int mixScovile(PriorityQueue<Integer> scovilleQueue, int K) {
		int count = 0;
		while (true) {
			if (scovilleQueue.peek() > K) break;
			if (scovilleQueue.size() < 2) return -1;
			scovilleQueue.offer(scovilleQueue.poll() + (scovilleQueue.poll() * 2));
			count++;
		}
		
		return count;
	}
}

public class MoreSpicy {
	public static void main(String[] args) {
		System.out.println(new Solution().solution(new int[] { 1, 2, 3, 9, 10, 12 }, 7));
		System.out.println(new Solution().solution(new int[] { 1, 1, 1 }, 7));
	}
}
