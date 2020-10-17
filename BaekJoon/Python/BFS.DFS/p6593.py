from collections import deque
import sys
input = sys.stdin.readline

while True:
    L, R, C = map(int, input().split())
    if L == 0 and R == 0 and C == 0:
        break
    building = []
    exit_x, exit_y, exit_z = -1, -1, -1
    start_x, start_y, start_z = -1, -1, -1
    for i in range(L):
        stage = []
        for j in range(R):
            row = list(input())[:-1]
            for k in range(C):
                if row[k] == 'E':
                    exit_x, exit_y, exit_z = i, j, k
                elif row[k] == 'S':
                    start_x, start_y, start_z = i, j, k
            stage.append(row)
        building.append(stage)
        a = input()

    visited = [[[-1]*C for _ in range(R)] for _ in range(L)]
    queue = deque()
    queue.append((start_x, start_y, start_z))
    visited[start_x][start_y][start_z] = 0
    escape = 0
    while queue:
        x, y, z = queue.popleft()
        if x == exit_x and y == exit_y and z == exit_z:
            print('Escaped in', visited[x][y][z], "minute(s).")
            escape = 1
            break
        for dx, dy, dz in (-1, 0, 0), (1, 0, 0), (0, -1, 0), (0, 1, 0), (0, 0, -1), (0, 0, 1):
            nx, ny, nz = x + dx, y + dy, z + dz
            if nx < 0 or nx >= L or ny < 0 or ny >= R or nz < 0 or nz >= C:
                continue
            if building[nx][ny][nz] == '#' or visited[nx][ny][nz] != -1:
                continue
            queue.append((nx, ny, nz))

            visited[nx][ny][nz] = visited[x][y][z] + 1

    if not escape:
        print('Trapped!')
    # for i in range(L):
    #     for j in range(R):
    #         print(visited[i][j])
