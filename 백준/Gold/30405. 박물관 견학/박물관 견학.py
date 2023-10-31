import sys
si = sys.stdin.readline

n, m = map(int, si().split())
arr = []
for _ in range(n) :
    lst = list(map(int, si().split()))
    arr.append(lst[1])
    arr.append(lst[-1])

arr.sort()

if len(arr) % 2 == 0 :
    print(arr[len(arr)//2-1])
else :
    print(arr[len(arr)//2])