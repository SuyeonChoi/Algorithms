from collections import deque
cnt = 1
while True:
    N = int(input())
    if N == 0:
        break
    graph = [list(map(int, input().split())) for _ in range(N)]
    INF = 10000000000
    dist = [[INF] * N for _ in range(N)]
    queue = deque()
    queue.append((0, 0))
    dist[0][0] = graph[0][0]
    while queue:
        x, y = queue.popleft()
        for dx, dy in (-1, 0), (1, 0), (0, -1), (0, 1):
            nx, ny = dx + x, dy + y
            if nx < 0 or nx >= N or ny < 0 or ny >= N:
                continue
            if dist[nx][ny] > dist[x][y] + graph[nx][ny]:
                dist[nx][ny] = dist[x][y] + graph[nx][ny]
                queue.append((nx, ny))
    print(f'Problem {cnt}:',dist[N-1][N-1])
    cnt += 1