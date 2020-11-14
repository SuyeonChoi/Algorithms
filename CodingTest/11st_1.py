# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

def solution(A):
    # write your code in Python 3.6
    if len(A) == 1:
        return 1
    _max = max(A)
    spike = {_max: 1}
    cnt = 1
    for n in A:
        if n == _max:
            continue
        if n in spike:
            if spike[n] < 2:
                spike[n] += 1
                cnt += 1
        else:
            spike[n] = 1
            cnt += 1
    return cnt

print(solution([2, 2]))


