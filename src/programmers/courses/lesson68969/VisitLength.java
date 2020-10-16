package courses.lesson68969;

import java.util.ArrayList;
import java.util.List;

class Solution {
	private final int X_LENGTH = 5;
	private final int Y_LENGTH = 5;

	public int solution(String dirs) {
		return countVisitedPosition(dirs.toCharArray());
	}

	private int countVisitedPosition(char[] moveArr) {
		int x = 0, y = 0;
		int count = 0;
		List<Position> visitedPosition = new ArrayList<Position>();
		int from = -1;
		for (char move : moveArr) {
			switch (move) {
			case 'L':
				if (x > -X_LENGTH) {
					x--;
					from = Position.R;
				}
				break;
			case 'R':
				if (x < X_LENGTH) {
					x++;
					from = Position.L;
				}
				break;
			case 'U':
				if (y < Y_LENGTH) {
					y++;
					from = Position.D;                                        
				}
				break;
			case 'D':
				if (y > -Y_LENGTH) {
					y--;
					from = Position.U;
				}
				break;
			}
			Position position = new Position(x, y);
			int index = visitedPosition.indexOf(position);
			if (index > 0) {
				if (!visitedPosition.get(index).isVisited[from]) {
					Position changedPosition = visitedPosition.get(index);
					changedPosition.setVisited(from);
					visitedPosition.set(index, changedPosition);
					count++;
				}
				
			} else {
				position.setVisited(from);
				visitedPosition.add(position);
				count++;
			}
			
		}
		return count;
	}

}

class Position {
	public static final int L = 0;
	public static final int R = 1;
	public static final int U = 2;
	public static final int D = 3;
	int x;
	int y;
	boolean[] isVisited; // {L, R, U, D} 방문한적이 있는지 기록

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
		isVisited = new boolean[4];
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Position) {
			Position std = (Position) obj;
			return (this.x == std.x && this.y == std.y);
		}
		return false;
	}

	// L, R, U, D
	public void setVisited(int i) {
		isVisited[i] = true;
	}

}

public class VisitLength {
	public static void main(String[] args) {
		System.out.println(new Solution().solution("ULURRDLLU"));
		System.out.println(new Solution().solution("LULLLLLLU"));

		System.out.println(new Solution().solution("RRRRRRRUUUUDDLDLDLD"));
	}
}
