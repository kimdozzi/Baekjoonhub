import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        List<Integer> list = new ArrayList<>();
        int[] isExist = new int[arr.length];
        
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<delete_list.length; j++) {
                if (arr[i] == delete_list[j]) {
                    isExist[i] = 1;
                    break;
                }
            }
        }
        
        for(int i=0; i<isExist.length; i++) {
            if (isExist[i] != 1) {
                list.add(arr[i]);
            }
        }
        
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}