import sys
si = sys.stdin.readline
s = si().rstrip()

i = 0
stk = []
new_str = ""
while True :
    if i == len(s) : break
    if s[i] == " " :
        if stk :
            new_str +=  "".join(stk[::-1]) + s[i]
            stk.clear()

    elif s[i] == "<" :
        if stk :
            new_str += "".join(stk[::-1])
            stk.clear()

        while s[i] != ">" :
            new_str += s[i]
            i += 1
        new_str += s[i]

    else:
        stk.append(s[i])
    i += 1

if stk :
    new_str += "".join(stk[::-1])

print(new_str)