import sys
si = sys.stdin.readline

a,b = map(int, si().split())

m = (10**9)+7

if a==1 :
    print(b%m)
    exit(0)

def power(a,b) :
    global m

    if b == 0 :
        return 1

    x = power(a, b//2)

    if b % 2 == 0 :
        return (x * x) % m

    else :
        return (x * x * a) % m


print(((power(a,b)-1)%m) * (power(a-1,m-2)%m) % m)