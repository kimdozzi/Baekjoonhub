def solution(s):
    s = list(map(int,s.split()))
    mx,mn = max(s),min(s)
    ans = str(mn) + " " + str(mx)
    return ans