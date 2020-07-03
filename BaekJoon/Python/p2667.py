from collections import deque
N = int(input())
village = [list(input()) for _ in range(N)]
visited = [[0]*N for _ in range(N)]
num = 0
house = list()
for i in range(N):
    for j in range(N):
        if village[i][j] == '1' and visited[i][j] == 0:
            queue = deque()
            queue.append((i, j))
            visited[i][j] = 1
            num += 1
            count = 1
            while queue:
                x, y = queue.popleft()
                for dx, dy in (-1, 0), (1, 0), (0, -1), (0, 1):
                    nx, ny = dx + int(x), dy + int(y)
                    if nx < 0 or nx >= N or ny < 0 or ny >= N:
                        continue
                    if visited[nx][ny] == 1 or village[nx][ny] == '0':
                        continue
                    queue.append((nx, ny))
                    visited[nx][ny] = 1
                    count += 1
            house.append(count)

print(num)
house.sort()
for i in range(len(house)):
    print(house[i])
