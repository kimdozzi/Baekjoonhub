import sys
si = sys.stdin.readline

def rec_func(_str, idx) :
    repeat = int(_str[idx-2])
    temp_len = 0

    while _str[idx] != ')' :
        if _str[idx] == '(' :
            len_res, idx = rec_func(_str, idx+1)
            temp_len += len_res
        else :
            temp_len += 1
            idx += 1

    return repeat * temp_len-1, idx+1

def main():
    S = si().rstrip()
    ans_len = 0
    i = 0
    while i < len(S) :
        if S[i] == '(' :
            len_res, i = rec_func(S, i+1)
            ans_len += len_res
        elif S[i] == ')' :
            i += 1
            continue
        else :
            ans_len += 1
            i += 1

    print(ans_len)

if __name__ == "__main__":
    main()