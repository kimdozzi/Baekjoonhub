import sys
from collections import defaultdict
si = sys.stdin.readline


cnt = 0
dic = defaultdict(int)

while True :
    s = si().rstrip()
    if len(s) < 1 : break
    cnt += 1
    dic[s] += 1

arr = [[k,v] for k,v in dic.items()]
arr.sort(key=lambda x: (x[0],x[1]))

for name, ratio in arr :
    print("%s %.4f"%(name, (ratio/cnt*100)))
