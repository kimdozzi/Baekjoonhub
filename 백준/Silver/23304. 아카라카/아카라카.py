import sys
si = sys.stdin.readline

def aka(s):
    n = len(s)
    if n == 1: return True

    xa, xb = s[:n//2], s[n-(n//2):]

    if xa == xb: return aka(xa)
    else: return False

a = si().rstrip()
if aka(a):
    print('AKARAKA')
else:
    print('IPSELENTI')