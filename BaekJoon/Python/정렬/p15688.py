import sys
input = sys.stdin.readline
N = int(input())
num = [int(input()) for _ in range(N)]
print('\n'.join(map(str, sorted(num))))