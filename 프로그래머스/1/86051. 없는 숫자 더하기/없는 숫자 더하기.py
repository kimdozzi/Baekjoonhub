from collections import defaultdict
def solution(numbers):
    answer = 0
    dic = defaultdict(int)
    for number in numbers :
        dic[number] += 1
    
    
    for i in range(10) :
        if i not in dic : 
            answer += i
    return answer