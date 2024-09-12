class Solution {
    public long solution(int n, int[] times) {
        long lo = 0;
        long hi = Long.MAX_VALUE/100;
        while(lo + 1 < hi) {
            long mid = lo + ((hi-lo)/2);
            
            long sum = 0;
            for(int i=0; i<times.length; i++){
                sum += mid/times[i];
            }
            
       
            if (sum < n) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return hi;
    }
}