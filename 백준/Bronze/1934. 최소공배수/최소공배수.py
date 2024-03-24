import sys, math
si = sys.stdin.readline
n=int(si())

def gcd(a,b) :
    if a < b :
        a,b=b,a

    while b!= 0:
        a,b=b,a%b

    return a

def lcm(a, b) :
    return a * b // gcd(a,b)

for _ in range(n) :
    a,b=map(int,si().split())

    print(lcm(a, b))