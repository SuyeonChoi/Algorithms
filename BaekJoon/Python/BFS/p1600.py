from collections import deque
import sys
input = sys.stdin.readline
K = int(input())
W, H = map(int, input().split())
map = [list(map(int, input().split())) for _ in range(H)]
visited = [[[0]*(K+1) for _ in range(W)] for _ in range(H)]
queue = deque()
hx = [-2, -2, -1, -1, 1, 1, 2, 2]
hy = [-1, 1, -2, 2, -2, 2, -1, 1]

def monkey(x, y, k):
    for dx, dy in (-1, 0), (1, 0), (0, -1), (0, 1):
        nx, ny = x + dx, y + dy
        if nx < 0 or nx >= H or ny < 0 or ny >= W:
            continue
        if map[nx][ny] == 0 and visited[nx][ny][k] == 0:
            visited[nx][ny][k] = visited[x][y][k] + 1
            queue.append((nx, ny, k))

def horse(x, y, k):
    for i in range(8):
        nx, ny = x + hx[i], y+hy[i]
        if nx < 0 or nx >= H or ny < 0 or ny >= W:
            continue
        if map[nx][ny] == 0 and visited[nx][ny][k+1] == 0:
            visited[nx][ny][k+1] = visited[x][y][k] + 1
            queue.append((nx, ny, k+1))
def bfs():
    queue.append((0, 0, 0))
    visited[0][0][0] = 1
    while queue:
        x, y, k = queue.popleft()
        if x == H-1 and y == W-1:
            print(visited[x][y][k] - 1)
            return
        if k < K:
            horse(x, y, k)
            monkey(x, y, k)
        else:
            monkey(x, y, k)
    print(-1)

bfs()
