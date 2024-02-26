import sys
si = sys.stdin.readline
n=int(si())
for i in range(1,n+1) :
    a,b=map(int,si().split())
    print(f"Case #{i}: {a+b}")