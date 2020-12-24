import sys
input = sys.stdin.readline
N = int(input())
tile = [0 for _ in range(31)]
tile[0] = 1
tile[2] = 3
for i in range(4, 31, 2):
    tile[i] = tile[i-2] * 3
    for j in range(4, i+1, 2):
        tile[i] += (tile[i-j] * 2)
print(tile[N])
