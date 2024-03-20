import sys
si = sys.stdin.readline
n=int(si())
s="int"
cnt=n//4
for i in range(cnt) :
    s = "long " + s
print(s)
