from collections import deque
M, N, K = map(int, input().split())
paper = [[0]*N for _ in range(M)]
visited = [[0]*N for _ in range(M)]
square = list()
for i in range(K):
    temp = list(map(int, input().split()))
    square.append(temp)

#insert squre in paper
for point in square:
    low_x, low_y, high_x, high_y = point[0], point[1], point[2], point[3]
    r = M - low_y - 1  # 행

    for row in range(point[3] - point[1]):
        c = low_x
        for col in range(point[2] - point[0]):
            paper[r][c] = 1
            c += 1
        r -= 1
section = list()

#BFS
queue = deque()
for i in range(M):
    for j in range(N):
        if paper[i][j] == 0 and visited[i][j] == 0:
            visited[i][j] = 1
            queue.append((i, j))
            width = 1
            while queue:
                x, y = queue.popleft()
                for dx, dy in (-1, 0), (1, 0), (0, -1), (0, 1):
                    nx, ny = x + dx, y + dy
                    if nx < 0 or nx >= M or ny < 0 or ny >= N:
                        continue
                    if visited[nx][ny] != 0 or paper[nx][ny] == 1:
                        continue
                    queue.append((nx, ny))
                    visited[nx][ny] = 1
                    width += 1
            section.append(width)

print(len(section))
section = sorted(section)
for i in section:
    print(i, end=' ')