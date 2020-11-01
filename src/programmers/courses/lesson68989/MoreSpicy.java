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
			if (scovilleQueue.peek() > K) {
				break;
			}
			if (scovilleQueue.size() < 2) {
				return -1;
			}
			scovilleQueue.offer(scovilleQueue.poll() + (scovilleQueue.poll() * 2));
			count++;
		}

		return count;
	}
}
