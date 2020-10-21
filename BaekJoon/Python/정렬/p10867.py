import sys
input = sys.stdin.readline
N = int(input())
num = set(map(int, input().split()))
num = sorted(num)
for i in num:
    print(i, end=' ')
