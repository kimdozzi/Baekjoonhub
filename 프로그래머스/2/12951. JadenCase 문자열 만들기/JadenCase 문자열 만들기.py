def solution(s):
    ans = ""
    for i in range(len(s)) : 
        if i == 0 : 
            ans += s[i].upper()
        elif i != 0 and s[i-1] == ' ' : 
            ans += s[i].upper()
        elif i != 0 and s[i-1] != ' ' and s[i].upper() :
            ans += s[i].lower()
        else : 
            ans += s[i]
    
    return ans
            
