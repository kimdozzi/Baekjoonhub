import math
import sys
si = sys.stdin.readline
n=int(si())

for _ in range(n) :
    a,b=map(int,si().split())
    print(math.factorial(b) // (math.factorial(b-a) * math.factorial(a)))

# 5C1
# 5P1 / 1!
# 5! (4!)*1!
# 5
