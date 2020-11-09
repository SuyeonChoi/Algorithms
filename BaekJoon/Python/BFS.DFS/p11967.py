from collections import deque
import sys
input = sys.stdin.readline
N, M = map(int, input().split())
barn = [[[]*N for _ in range(N)] for _ in range(N)]
light = [[0]*N for _ in range(N)]
light[0][0] = 1

for i in range(M):
    x, y, a, b = map(int, input().split())
    barn[x-1][y-1].append((a-1, b-1))

while True:
    queue = deque()
    queue.append((0, 0))
    newLight = False
    visited = [[0] * N for _ in range(N)]
    visited[0][0] = 1
    while queue:
        x, y = queue.popleft()
        for nx, ny in barn[x][y]:
            if light[nx][ny] == 0:
                light[nx][ny] = 1
                newLight = True
        for dx, dy in (-1, 0), (1, 0), (0, -1), (0, 1):
            nx, ny = x + dx, y + dy
            if nx < 0 or nx >= N or ny < 0 or ny >= N:
                continue
            if visited[nx][ny] == 0 and light[nx][ny] == 1:
                queue.append((nx, ny))
                visited[nx][ny] = 1
    if not newLight:
        break

cnt = 0
# print(light)
for i in range(N):
    for j in range(N):
        if light[i][j] == 1:
            cnt += 1
print(cnt)