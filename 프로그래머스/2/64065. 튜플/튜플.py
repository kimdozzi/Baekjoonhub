from collections import Counter
def solution(s):
    arr = []
    s = list(map(int,s.replace("{","").replace("}","").split(",")))
    s = Counter(s).most_common(len(s))
    for k,v in s :
        arr.append(k)    
    return arr