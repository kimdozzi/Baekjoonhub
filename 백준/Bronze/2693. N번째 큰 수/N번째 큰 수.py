import sys
si =sys.stdin.readline
n=int(si())
for _ in range(n) :
    lst=list(map(int,si().split()))
    lst.sort()
    print(lst[-3])