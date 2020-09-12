def solution(s):
    if len(s) == 1:
        return 1
    answer = 0
    length = []
    _string = list(s)
    for i in range(1, len(s)//2+1):
        tmp = ""
        cnt = 1
        for j in range(0, len(s)-i, i):
            first = ''.join(_string[j:j+i])
            second = ''.join(_string[j+i:j+2*i])
            if first == second:
                cnt += 1
            elif first != second:
                if cnt == 1:
                    tmp += first
                else:
                    tmp += (str(cnt) + first)
                    cnt = 1
            if j+i >= (len(s)-i):
                if cnt == 1:
                    tmp += second
                else:
                    tmp += (str(cnt) + second)

        length.append(len(tmp))

    answer = min(length)
    return answer

print(solution("ab"))