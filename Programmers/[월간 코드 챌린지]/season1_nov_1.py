def solution(a, b):
    answer = 0
    for fir, sec in zip(a, b):
        answer += (fir * sec)
    return answer