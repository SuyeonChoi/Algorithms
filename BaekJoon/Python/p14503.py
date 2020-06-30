from collections import deque
N, M = map(int, input().split())
x, y, d = map(int, input().split())
room = [list(map(int, input().split())) for _ in range(N)]
visited = [[0]*M for _ in range(N)]

direction = {0: (0, -1), 1: (-1, 0), 2: (0, 1), 3: (1, 0)}
back = {0: (1, 0), 1: (0, -1), 2:(-1, 0), 3: (0, 1)}
rotate = {0: 3, 1: 0, 2: 1, 3: 2}
queue = deque()
queue.append((x, y, d))
visited[x][y] = 1
count = 1
rot = 0
while queue:
    x, y, d = queue.popleft()
    dx, dy = direction[d]
    nx, ny = dx + x, dy + y
    # 조건 c
    if rot >= 4:
        dx, dy = back[d]
        nx, ny = x + dx, y + dy
        # 조건 d
        if room[nx][ny] == 1:
            break
        queue.append((nx, ny, d))
        rot = 0
        continue
    #조건 a
    if room[nx][ny] == 0 and visited[nx][ny] == 0:
        if d == 0:
            d = 3
        else:
            d = d - 1
        visited[nx][ny] = 1
        queue.append((nx, ny, d))
        count += 1
        rot = 0
        continue

    #조건 b
    if room[nx][ny] == 1 or visited[nx][ny] != 0:
        if d == 0:
             d = 3
        else:
            d = d - 1
        queue.append((x, y, d))
        rot += 1


print(count)