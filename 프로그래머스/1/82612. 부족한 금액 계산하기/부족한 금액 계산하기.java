class Solution {
    public long solution(int price, int money, int count) {
        long total = 0;
        for(int i=1; i<=count; i++) {
            total += price * i;
        }
        
        if (money - total >= 0) return 0;
        
        return (long) Math.abs(total - money);
    }
}