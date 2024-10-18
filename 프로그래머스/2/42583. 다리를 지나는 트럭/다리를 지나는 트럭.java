import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> trucks = new LinkedList<>();
        Queue<int[]> bridge = new LinkedList<>();
        for(int i=0; i<truck_weights.length; i++) {
            trucks.add(truck_weights[i]);
        }
        
        int time = 0, curWeight = 0;
        while(!trucks.isEmpty() || !bridge.isEmpty()) {
            if (!bridge.isEmpty() && bridge.peek()[0] <= time) {
                int[] temp = bridge.poll();
                curWeight -= temp[1];
            }
            if (!trucks.isEmpty() && bridge.size() + 1 <= bridge_length && 
               curWeight + trucks.peek() <= weight) {
                int w = trucks.poll();
                curWeight += w; 
                bridge.add(new int[]{time + bridge_length, w});
            }
            time++;
        }
        return time;
        
    }
}







