class Solution {
    public int solution(int[][] board, int[][] skill) {
        int n = board.length;
        int m = board[0].length;
        int[][] imos = new int[n + 1][m + 1];
        
        // 스킬 적용
        for (int[] s : skill) {
            int type = s[0], r1 = s[1], c1 = s[2], r2 = s[3], c2 = s[4], degree = s[5];
            int value = type == 1 ? -degree : degree;
            
            imos[r1][c1] += value;
            imos[r2 + 1][c1] -= value;
            imos[r1][c2 + 1] -= value;
            imos[r2 + 1][c2 + 1] += value;
        }
        
        
        
        
        // 누적합 계산
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i > 0) imos[i][j] += imos[i - 1][j];
                if (j > 0) imos[i][j] += imos[i][j - 1];
                if (i > 0 && j > 0) imos[i][j] -= imos[i - 1][j - 1];
                
                board[i][j] += imos[i][j];
            }
            
        }
        
        // 파괴되지 않은 건물 수 계산
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] > 0) answer++;
            }
        }
        
        return answer;
    }
    
    private static void print(int n, int m, int[][] board) {
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}