from collections import deque

case = int(input())
for i in range(case):
    M, N, num = map(int, input().split())
    farm = [[0]*N for _ in range(M)]
    visited = [[0]*N for _ in range(M)]
    queue = deque()
    bug = 0
    for j in range(num):
        x, y = map(int, input().split())
        farm[x][y] = 1
    for j in range(M):
        for k in range(N):
            if farm[j][k] == 1 and visited[j][k] == 0:
                bug += 1
                visited[j][k] = 1
                queue.append((j, k))
                while queue:
                    x, y = queue.popleft()
                    for dx, dy in (-1, 0), (1, 0), (0, -1), (0, 1):
                        nx, ny = dx + x, dy + y
                        if nx < 0 or nx >= M or ny < 0 or ny >= N:
                            continue
                        if farm[nx][ny] == 1 and visited[nx][ny] == 0:
                            queue.append((nx, ny))
                            visited[nx][ny] = 1
    print(bug)

