def solution(board, skill):
    r = len(board)
    c = len(board[0])
    
    prefix_sum = [[0] * (c+1) for _ in range(r+1)]
    
    for i in range(len(skill)) :
        ty, r1,c1,r2,c2,degree = skill[i]
        if ty == 1 :
            prefix_sum[r1][c1] += degree
            prefix_sum[r2+1][c2+1] += degree
            prefix_sum[r1][c2+1] -= degree
            prefix_sum[r2+1][c1] -= degree
        else :
            prefix_sum[r1][c1] -= degree
            prefix_sum[r2+1][c2+1] -= degree
            prefix_sum[r1][c2+1] += degree
            prefix_sum[r2+1][c1] += degree
            
    for i in range(len(prefix_sum)) :
        for j in range(1,len(prefix_sum[i])) :
            prefix_sum[i][j] = prefix_sum[i][j-1] + prefix_sum[i][j]
    
    for j in range(len(prefix_sum[0])) :
        for i in range(1,len(prefix_sum)) :
            prefix_sum[i][j] = prefix_sum[i-1][j] + prefix_sum[i][j]
    
    answer = 0
    for i in range(len(board)) :
        for j in range(len(board[i])) :
            board[i][j] -= prefix_sum[i][j]
            if board[i][j] > 0 : answer += 1
    
    return answer