class Solution {
    public int[] solution(int n, int m) {
        int[] answer = {};
        
        int x = gcd(n,m);
        int y = lcm(n,m,x);
        
        return new int[]{x,y};
    }
    private int lcm(int a, int b,int x) {
        return a * b / x;
    }
    
    private int gcd(int a, int b) {
        if (b == 0) 
            return a;
        else 
            return gcd(b, a%b);
    }
}