class Solution {
    public int[] solution(int[] arr) {
        int s=-1, e=100001;
        for(int i=0; i<arr.length; i++) {
            if(s == -1 && arr[i] == 2) {
                s = i;
                break;
            } 
        }
        for(int i=arr.length-1; i>=0; i--) {
            if(e == 100001 && arr[i] == 2) {
                e = i;
                break;
            } 
        }
        
        if (s == -1 && e == 100001) return new int[]{-1};
        
        int[] answer = new int[e-s+1];
        for(int i=s, idx=0; i<=e; i++, idx++) {
            answer[idx] = arr[i];
        }
        
        return answer;
    }
}