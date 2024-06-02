def solution(s):
    stk = []
    
    i = 0
    while True :
        if i >= len(s) : break
        if not stk : 
            stk.append(s[i])
            i += 1
            continue
        
        if stk and stk[-1] == s[i] : 
            stk.pop()
        elif stk and stk[-1] != s[i] :
            stk.append(s[i])
        i += 1
    
    print(stk)
    return 1 if not stk else 0