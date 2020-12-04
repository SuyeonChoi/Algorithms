from collections import deque
N = int(input())
scope = []
vis = [[0 for _ in range(N)] for _ in range(N)]
for i in range(N):
    tmp = list(map(int, input().split()))
    scope.append(tmp)
# print(vis)
# print(scope)
cnt = 0
areas = []
def bfs(queue, vis, scope, N):
    measure = 1
    while queue:
        x, y = queue.popleft()
        for dx, dy in (-1, 0), (1, 0), (0, -1), (0, 1):
            nx, ny = x + dx, y + dy
            if nx < 0 or nx >= N or ny < 0 or ny >= N:
                continue
            if vis[nx][ny] == 1 or scope[nx][ny] == 0:
                continue
            queue.append((nx, ny))
            vis[nx][ny] = 1
            measure += 1
    return vis, measure


for i in range(N):
    for j in range(N):
        if scope[i][j]==1 and vis[i][j] == 0:
            cnt += 1
            queue = deque()
            queue.append((i, j))
            vis[i][j] = 1
            vis, area = bfs(queue, vis, scope, N)
            areas.append(area)

print(cnt)
print(' '.join(map(str, sorted(areas))))