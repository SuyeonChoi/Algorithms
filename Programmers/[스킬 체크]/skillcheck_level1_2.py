from itertools import combinations
def solution(numbers):
    idx = combinations(numbers, 2)
    answer = []
    for x, y in idx:
        z = x + y
        if z not in answer:
            answer.append(z)

    return sorted(answer)

print(solution([2,1,3,4,1]	))