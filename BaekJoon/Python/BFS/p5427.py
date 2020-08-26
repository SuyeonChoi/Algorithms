import sys
from collections import deque
input = sys.stdin.readline
case = int(input())
for c in range(case):
    w, h = map(int, input().split())
    building = list()
    fire = [[-1]*w for _ in range(h)]
    escape = [[-1]*w for _ in range(h)]
    fire_queue = deque()
    escape_queue = deque()
    for i in range(h):
        tmp = list(input())
        building.append(tmp)
        for j in range(w):
            if tmp[j] == '*':
                fire[i][j] = 0
                fire_queue.append((i, j))
            if tmp[j] == '@':
                escape[i][j] = 0
                escape_queue.append((i, j))
    while fire_queue:
        x, y = fire_queue.popleft()
        for dx, dy in (-1, 0), (1, 0), (0, -1), (0, 1):
            nx, ny = x + dx, y + dy
            if nx < 0 or nx >= h or ny < 0 or ny >= w:
                continue
            if building[nx][ny] == '#' or fire[nx][ny] != -1:
                continue
            fire[nx][ny] = fire[x][y] + 1
            fire_queue.append((nx, ny))
    escapeTime = 0
    while escape_queue:
        x, y = escape_queue.popleft()
        if escapeTime:
            break
        for dx, dy in (-1, 0), (1, 0), (0, -1), (0, 1):
            nx, ny = x + dx, y + dy
            if nx < 0 or nx >= h or ny < 0 or ny >= w:
                escapeTime = escape[x][y] + 1
                break
            if building[nx][ny] == '#' or escape[nx][ny] != -1:
                continue
            if fire[nx][ny] != -1 and escape[x][y] + 1 >= fire[nx][ny]:
                continue
            escape[nx][ny] = escape[x][y] + 1
            escape_queue.append((nx, ny))
    if escapeTime:
        print(escapeTime)
    else:
        print('IMPOSSIBLE')
