import sys
si = sys.stdin.readline

n=int(si())
arr=list(map(int,si().split()))
m=int(si())
mn, mx = min(arr), max(arr)
start, end = 1, mx
ans = 0
while start <= end :
    mid = (start + end) // 2
    res = 0

    for i in range(len(arr)) :
        if arr[i] <= mid :
            res += arr[i]
        else :
            res += mid


    if res > m :
        end -= 1
    else :
        start += 1

    if res <= m :
        ans = max(ans, mid)

print(ans)