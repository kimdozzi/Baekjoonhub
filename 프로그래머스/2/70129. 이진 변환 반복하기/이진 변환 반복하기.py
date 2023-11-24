def solution(s):
    cnt = 0
    ans = 0
    while len(s) > 1 :
        cnt += 1
        num = s.count('1')
        ans += len(s)-num
        s = bin(num)[2:]
        
    return [cnt,ans]