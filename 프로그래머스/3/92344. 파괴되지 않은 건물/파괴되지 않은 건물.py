def solution(board, skill):
    r = len(board)
    c = len(board[0])

    prefix_sum = [[0] * (c+2) for _ in range(r+2)]

    for i in range(len(skill)) :
        ty, r1,c1,r2,c2,degree = skill[i]
        r1 +=1; r2+=1; c1+=1; c2+=1
        if ty == 1 :
            degree *= -1
        prefix_sum[r1][c1] += degree
        prefix_sum[r2+1][c2+1] += degree
        prefix_sum[r1][c2+1] -= degree
        prefix_sum[r2+1][c1] -= degree
        

#     for i in range(len(prefix_sum)) :
#         for j in range(1,len(prefix_sum[i])) :
#             prefix_sum[i][j] = prefix_sum[i][j-1] + prefix_sum[i][j]

#     for j in range(len(prefix_sum[0])) :
#         for i in range(1,len(prefix_sum)) :
#             prefix_sum[i][j] = prefix_sum[i-1][j] + prefix_sum[i][j]
    
    for i in range(1,r+1) :
        for j in range(1,c+1):
            prefix_sum[i][j] += prefix_sum[i-1][j] + prefix_sum[i][j-1] - prefix_sum[i-1][j-1]

    answer = 0
    for i in range(r) :
        for j in range(c) :
            board[i][j] += prefix_sum[i+1][j+1]
            if board[i][j] > 0 : answer += 1

    return answer
