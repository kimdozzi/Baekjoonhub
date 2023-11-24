def solution(s):
    length = len(s)
    cnt = 0
    ans = 0
    while length > 1 :
        cnt += 1
        s = s.replace("0","")
        ans+=length-len(s)
        s = bin(len(s))[2:]
        length = len(s)
        
    return [cnt,ans]