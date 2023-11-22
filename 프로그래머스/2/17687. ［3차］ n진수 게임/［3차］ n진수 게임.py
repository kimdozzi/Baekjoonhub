def solution(n, t, m, p):
    def solve(x, k):
        s = "0"
        while x:
            tmp = str(x%k)
            
            if tmp == '10' :
                s += 'A'
            elif tmp == '11' :
                s += 'B'
            elif tmp == '12' :
                s += 'C'
            elif tmp == '13' :
                s += 'D'
            elif tmp == '14' :
                s += 'E'
            elif tmp == '15' :
                s += 'F'
            else :
                s += tmp
            x //= k
            
        if not s :
            return '0'
        return s[::-1]
    
    max_length = 0
    num = ''
    for i in range(1, m * t) :
        num += solve(i, n)
        max_length += len(num)
        
    
    return num[p-1::m][:t]




def solution(n, t, m, p):
    answer = "0"
    notation = "0123456789ABCDEF"

    for num in range(1, m * t):
        result = ""
        while num > 0:
            num, remainder = divmod(num, n)
            result += notation[remainder]

        answer += result[::-1]


    return answer[p-1::m][:t]



