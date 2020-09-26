def solution(n, lost, reserve):
    lost.sort()
    reserve.sort()
    weird = []
    for i in lost:
        if i in reserve:
            weird.append(i)
    for i in weird:
        lost.remove(i)
        reserve.remove(i)
    lost_size = len(lost)
    for i in range(lost_size):
        idx = lost.pop(0)
        check = 1
        for j in range(len(reserve)):
            if idx-1 == reserve[j]:
                reserve.pop(j)
                check = 0
                break
            if idx + 1 == reserve[j]:
                reserve.pop(j)
                check = 0
                break
        if check:
            lost.append(idx)
    answer = n - len(lost)
    return answer

print(solution(3, [1, 2], [1, 2]))