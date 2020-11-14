# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")
import fractions
def solution(X, Y):
    # write your code in Python 3.6
    frac = dict()
    for x, y in zip(X, Y):
        tmp = fractions.Fraction(x, y)
        if tmp in frac:
            frac[tmp] += 1
        else:
            frac[tmp] = 1
    return max(frac.values())

print(solution([1, 2, 3, 4, 0], [2, 3, 6, 8, 4]))
