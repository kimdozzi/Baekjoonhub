import sys
si = sys.stdin.readline

n,m=map(int,si().split())
dic = {}
for _ in range(n) :
    k,v=si().rstrip().split(" ")
    dic[k]=v

for _ in range(m) :
    x = si().rstrip()
    print(dic[x])