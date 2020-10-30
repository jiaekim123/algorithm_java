package courses.lesson68994;

import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
	public int solution(int[][] maps) {
		Queue<Integer> countQueue = new PriorityQueue<Integer>();
		boolean[][] visited = new boolean[maps.length][maps[0].length];
		bfs(maps, visited, 0, 0, countQueue, 0, direction.START);
		if (countQueue.isEmpty()) {
			return -1;
		} else {
			return countQueue.peek();
		}
	}

	private void bfs(int[][] map, boolean[][] visited, int x, int y, Queue<Integer> countQueue, int count,
			direction d) {
		count++;
		if (y == map.length - 1 && x == map[0].length - 1) {
			countQueue.offer(count);
			return;
		} else {
			visited[y][x] = true;
			if (y < map.length - 1 && map[y + 1][x] == 1 && visited[y + 1][x] == false && d != direction.UP) {
				bfs(map, visited, x, y + 1, countQueue, count, direction.DOWN);
				visited[y][x] = false;
			}
			if (x < map[0].length - 1 && map[y][x + 1] == 1 && visited[y][x + 1] == false && d != direction.LEFT) {
				bfs(map, visited, x + 1, y, countQueue, count, direction.RIGHT);
				visited[y][x] = false;
			}
			if (x > 0 && map[y][x - 1] == 1 && visited[y][x - 1] == false && d != direction.RIGHT) {
				bfs(map, visited, x - 1, y, countQueue, count, direction.LEFT);
				visited[y][x] = false;
			}
			if (y > 0 && map[y - 1][x] == 1 && visited[y - 1][x] == false && d != direction.DOWN) {
				bfs(map, visited, x, y - 1, countQueue, count, direction.UP);
				visited[y][x] = false;
			}
		}
	}

	enum direction {
		RIGHT, LEFT, UP, DOWN, START;
	}
}

public class MinDistGameMap {

	public static void main(String[] args) {
		System.out.println(new Solution().solution(new int[][] { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 },
				{ 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 1 }, { 0, 0, 0, 0, 1 } }));
		System.out.println(new Solution().solution(new int[][] { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 },
			{ 1, 0, 1, 0, 1 }, { 1, 1, 1, 0, 1 }, { 0, 0, 0, 0, 1 } }));
		System.out.println(new Solution().solution(new int[][] { { 1, 0, 1, 0, 1 }, { 1, 0, 1, 0, 1 },
			{ 1, 0, 1, 0, 1 }, { 1, 1, 1, 0, 1 }, { 0, 0, 0, 0, 1 } }));
		System.out.println(new Solution().solution(new int[][] { { 1, 1, 1, 1, 1 }, { 0, 0, 0, 0, 1 },
			{ 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 0 }, { 1, 1, 1, 1, 1 } }));

	}

}
