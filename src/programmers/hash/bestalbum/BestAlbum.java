package hash.bestalbum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
    	
       	HashMap<String, Integer> genreMap = new HashMap<String, Integer>(); // <장르, 노래 갯수>
       	HashMap<String, Integer> playMap = new HashMap<String, Integer>(); // <고유번호, 플레이 횟수>
        List<Album> albumList = new ArrayList<Album>();
        List<Integer> bestAlbumList = new ArrayList<Integer>();

        // albumList를 채운다
        for (int i=0; i<genres.length; i++) {
        	albumList.add(new Album(i, genres[i], plays[i]));
        	if (!genreMap.containsKey(genres[i])) {
        		
        	}
        }
        
        // 속한 노래가 가장 많은 장르를 찾는다.
        
        
        // albumList를 정렬한다.
        Collections.sort(albumList, new Comparator<Album>() {
			@Override
			public int compare(Album o1, Album o2) {
				// TODO Auto-generated method stub
				return 0;
			}
		});
        
        // bestAlbumList를 구한다.
        int[] answer = new int[bestAlbumList.size()];
        for (int i = 0; i<bestAlbumList.size(); i++) {
        	answer[i] = bestAlbumList.get(i);
        }
        return answer;
    }
}

class Album implements Comparable<Album>{
	private int play;
	private String genres;
	private int id;
	public Album(int id, String genres, int play) {
		this.genres = genres;
		this.play = play;
		this.id = id;
	}
	
	@Override
	public boolean equals(Object genres) {
		if (genres.toString() == this.genres) {
			return true;			
		} else {
			return false;
		}
	}
	
	@Override
	public int compareTo(Album album) {
		if (this.play == album.play) {
			return this.id = album.id;
		} else {
			return -(this.play - album.play);
		}
	}
}

public class BestAlbum {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.solution(new String[]{"classic", "pap", "classic", "classic", "pop"}, new int[] {500, 600, 150, 800, 2500}));
	}
}
