class Solution {
    public int[] solution(int n, int k) {
        int ans = k;
        int[] answer = new int[n/k];
        for(int i=0; i<n/k; i++) {
            answer[i] = ans;
            ans+=k;
        }
        return answer;
    }
}