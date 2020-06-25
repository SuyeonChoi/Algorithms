from collections import deque

N, M = map(int, input().split())
maze = [list((input())) for _ in range(N)]
visited = [[-1]*M for _ in range(N)]

queue = deque()
queue.append((0, 0))
visited[0][0] = 0
while queue:
    x, y = queue.popleft()
    for dx, dy in (-1, 0), (1, 0), (0, -1), (0, 1):
        nx, ny = x+dx, y+dy
        if nx < 0 or nx >= N or ny < 0 or ny >= M:
            continue
        if maze[nx][ny] == '1' and visited[nx][ny] == -1:
            queue.append((nx, ny))
            visited[nx][ny] = visited[x][y] + 1

print(visited[N-1][M-1]+1)
