def solution(s):
    s = list(map(int, s))
    cnt, zero = 0, 0
    while s != [1]:
        cnt += 1
        tmp = list(filter(lambda x: x != 0, s))
        zero += (len(s) - len(tmp))
        s = tmp
        s = list(map(int, list(bin(len(s)))[2:]))

    answer = [cnt, zero]
    return answer

print(solution("110010101001"))
