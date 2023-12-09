import sys,copy
si = sys.stdin.readline

s=si().rstrip()

if len(s) <= 3 :
    for i in range(len(s)) :
        if s[i] != s[len(s)-i-1] :
            print("IPSELENTI")
    print("AKARAKA")
    exit(0)

def is_palindrome(s) :
    half_length = len(s) // 2
    if len(s) % 2 == 0 :
        prefix = s[:half_length]
        suffix = s[half_length:]
    else :
        prefix = s[:half_length]
        suffix = s[half_length + 1:]

    if half_length == 2 :
        if prefix == suffix[::-1]:
            print("AKARAKA")
        else:
            print("IPSELENTI")
        exit(0)

    if half_length > 1 :
        is_palindrome(prefix)
        is_palindrome(suffix)
    else :
        if prefix == suffix[::-1] :
            return
        else :
            print("IPSELENTI")
            exit(0)

    print("AKARAKA")
    exit(0)

is_palindrome(s)