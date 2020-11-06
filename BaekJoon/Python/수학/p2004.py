from itertools import combinations
import sys
input = sys.stdin.readline
n, m = map(int, input().split())
def count(n, k):
    cnt = 0
    while n != 0:
        cnt += n
        n = n // k
    return cnt
print(min(count(n, 5)-count(m, 5) - count(n-m, 5), count(n, 2)-count(m,2)-count(n-m,2)))
