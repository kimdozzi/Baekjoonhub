import sys
si = sys.stdin.readline

n=int(si())
arr=list(map(int,si().split()))
target=int(si())
arr.sort()
lo,hi=0,len(arr)-1
cnt = 0
while lo < hi :
    x=arr[lo]+arr[hi]
    if x == target :
        cnt += 1
        while arr[hi-1] == arr[hi] :
            cnt += 1
            hi -= 1
        lo += 1

    elif x > target :
        hi -= 1
    else :
        lo += 1

print(cnt)

