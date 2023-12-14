import sys
si = sys.stdin.readline

n=int(si())
arr=list(map(int,si().split()))
m=int(si())
start, end = 0, max(arr)+1
while start + 1 < end :
    mid = (start + end) // 2
    res = 0

    for i in range(len(arr)) :
        if arr[i] <= mid :
            res += arr[i]
        else :
            res += mid

    if res > m :
        end = mid
        mid -= 1
    else :
        start = mid
        mid += 1


print(end-1)