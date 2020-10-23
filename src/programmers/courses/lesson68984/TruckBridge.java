package courses.lesson68984;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        Bridge bridge = new Bridge(bridge_length, weight);
        for (int i = 0; i<truck_weights.length; i++) {
        	
        	
        }
        return time;
    }
}

class Truck {
	int weight;
	int position;
	
	public Truck(int weight, int position) {
		this.weight = weight;
		this.position = position;
	}
}

class Bridge {
	private int bridgeWeight;
	private int truckWeights;
	private int bridgeLength;
	private int time;
	private List<Truck> truckList = new ArrayList<Truck>();
	
	public Bridge(int bridgeLength, int birdgeWeight) {
		this.bridgeLength = bridgeLength;
		this.bridgeWeight = bridgeWeight;
		this.truckWeights = 0;
		this.time= 0;
	}
	
	public boolean addTruck(Truck truck) {
		if (truckWeights + truck.weight < bridgeWeight) {
			truckList.add(truck);
			truckWeights += truck.weight;
			return true;
		}
		return false;
	}
	
	public void addTime(int time) {
		this.time += time;
	}
	
	public int getTime() {
		return time;
	}
	
}

public class TruckBridge {
	public static void main(String[] args) {
		System.out.println(new Solution().solution(2, 10, new int[] {7,4,5,6}));
//		System.out.println(new Solution().solution(100, 100, new int[] {10}));
//		System.out.println(new Solution().solution(100, 100, new int[] {10,10,10,10,10,10,10,10,10,10}));
	}
}
