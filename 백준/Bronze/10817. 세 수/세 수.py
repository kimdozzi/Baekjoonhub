import sys
si = sys.stdin.readline
# 20 30 10
arr=list(map(int,si().split()))
arr.sort()
print(arr[1])
