import sys
input = sys.stdin.readline
N = int(input())
num = list(map(int, input().split()))
M = int(input())
test = list(map(int, input().split()))
for t in test:
    print(num.count(t), end=' ')