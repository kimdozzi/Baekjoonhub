import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int n = elements.length;
        
        // 원본 배열을 2배로 늘려서 순환을 쉽게 처리
        int[] doubledElements = new int[n * 2];
        for(int i = 0; i < n; i++) {
            doubledElements[i] = elements[i];
            doubledElements[i + n] = elements[i];
        }
        
        // 길이 1부터 n까지의 모든 연속 부분 수열의 합
        for(int len = 1; len <= n; len++) {
            // 첫 번째 윈도우의 합을 계산
            int sum = 0;
            for(int i = 0; i < len; i++) {
                sum += doubledElements[i];
            }
            set.add(sum);
            
            // 슬라이딩 윈도우로 나머지 합을 계산
            for(int i = 1; i <= n - 1; i++) {
                sum = sum - doubledElements[i - 1] + doubledElements[i + len - 1];
                set.add(sum);
            }
        }
        
        return set.size();
    }
}