import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] arr) {
        if (arr.length == 1) return new int[]{-1};
        
        int min_n = 100000000, idx = -1;
        for (int i=0; i<arr.length; i++) {
            if (arr[i] < min_n) {
                min_n = arr[i];
                idx = i;
            }
        }
        
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<arr.length; i++) {
            if (i == idx) continue;
            list.add(arr[i]);
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
        
    }
}