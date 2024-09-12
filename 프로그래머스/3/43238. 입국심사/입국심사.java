class Solution {
    // https://20240228.tistory.com/96
    public long solution(int n, int[] times) {
        long lo = 0;
        long hi = Long.MAX_VALUE/100;
        System.out.println(hi);
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