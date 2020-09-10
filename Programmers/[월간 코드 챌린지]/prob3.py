def solution(a):
    answer = 0
    if len(a) <= 2:
        return len(a)

    tmp = a[2:]
    right = min(tmp)
    left = a[0]
    for i in range(len(a)):
        if i == 0 or i == len(a)-1:
            answer += 1
            continue
        mid = a[i]
        if mid == right:
            right = min(sorted(a[i+1:]))
        if mid < left or mid < right:
            answer += 1
        if mid < left:
            left = mid
    return answer