from collections import deque
import sys
input = sys.stdin.readline
N, M = map(int, input().split())
north = []
years = 0
for i in range(N):
    tmp = list(map(int, input().split()))
    north.append(tmp)

def bfs(north, queue, vis):
    while queue:
        x, y = queue.popleft()
        for dx, dy in (-1, 0), (1, 0), (0, -1), (0, 1):
            nx, ny = x + dx, y + dy
            if nx < 0 or nx >= N or ny < 0 or ny >= M:
                continue
            if north[nx][ny] == 0 and vis[nx][ny] == 0:
                queue.append((nx, ny))
                vis[nx][ny] = 1
            if north[nx][ny] != 0:
                north[nx][ny] -= 1
                if north[nx][ny] == 0:
                    vis[nx][ny] = 1
    return north


def countIce(queue, vis):
    while queue:
        x, y = queue.popleft()
        for dx, dy in (-1, 0), (1, 0), (0, -1), (0, 1):
            nx, ny = x + dx, y + dy
            if nx < 0 or nx >= N or ny < 0 or ny >= M:
                continue
            if north[nx][ny] and vis[nx][ny] == 0:
                queue.append((nx, ny))
                vis[nx][ny] = 1
    return vis


def isOne():
    visited = [[0 for _ in range(M)]for _ in range(N)]
    queue_ = deque()
    chk = 0
    for i in range(1, N-1):
        for j in range(1, M-1):
            if north[i][j] and visited[i][j] == 0:
                if chk:
                    return chk+1
                queue_.append((i, j))
                visited[i][j] = 1
                visited = countIce(queue_, visited)
                chk += 1
    return chk


while True:
    queue = deque()
    vis = [[0 for _ in range(M)]for _ in range(N)]
    cnt = isOne()
    if cnt == 0:
        years = 0
        break
    elif cnt != 1:
        break
    for i in range(N):
        for j in range(M):
            if north[i][j] == 0:
                queue.append((i, j))
                vis[i][j] = 1
    north = bfs(north, queue, vis)
    years += 1

print(years)
