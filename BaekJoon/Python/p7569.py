from collections import deque
M, N, H = map(int, input().split())
container = list()
dist = [[[0]*M for _ in range(N)] for _ in range(H)]
queue = deque()

for i in range(H):
    floor = list()
    for j in range(N):
        line = list(map(int, input().split()))
        floor.append(line)
        for k in range(M):
            if line[k] == 1:
                queue.append((i, j, k))
            if line[k] == -1:
                dist[i][j][k] = -1
    container.append(floor)

days = 0
while queue:
    x, y, z = queue.popleft()
    for dx, dy, dz in (-1, 0, 0), (1, 0, 0), (0, -1, 0), (0, 1, 0), (0, 0, -1), (0, 0, 1):
        nx, ny, nz = dx + x, dy + y, dz + z
        if nx < 0 or ny < 0 or nz < 0 or nx >= H or ny >= N or nz >= M:
            continue
        if container[nx][ny][nz] == 0:
            dist[nx][ny][nz] = dist[x][y][z] + 1
            container[nx][ny][nz] = 1
            queue.append((nx, ny, nz))
            days = max(days, dist[nx][ny][nz])

check = 0
for i in range(H):
    for j in range(N):
        for k in range(M):
            if container[i][j][k] == 0:
                check = 1
if check == 0:
    print(days)
else:
    print(-1)