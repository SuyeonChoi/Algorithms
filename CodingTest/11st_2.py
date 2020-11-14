# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")
from itertools import combinations

def solution(A):
    # write your code in Python 3.6
    idx = [i for i in range(len(A))]
    perimeter = []
    for p, q, r in list(combinations(idx, 3)):
        if (A[p] + A[q] > A[r]) and (A[q] + A[r] > A[p]) and (A[r] + A[p] > A[q]):
            perimeter.append(A[p] + A[q] + A[r])
    if perimeter:
        return max(perimeter)
    return -1

print(solution([0]))