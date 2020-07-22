import sys
import copy
input = sys.stdin.readline
N, M = map(int, input().split())
office = []
office2 = [[0]*M for _ in range(N)]
cctv = []
unseen = 0
for i in range(N):
    temp = list(map(int, input().split()))
    office.append(temp)
    for j in range(M):
        if 0 < temp[j] < 6:
            cctv.append((i, j))
        if temp[j] == 0:
            unseen += 1
dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]
def mark(x, y, dir):
    global office2, dx, dy
    dir %= 4
    while True:
        x += dx[dir]
        y += dy[dir]
        if x < 0 or x >= N or y < 0 or y >= M or office2[x][y] == 6:
            return
        if office2[x][y] != 0:
            continue
        office2[x][y] = '#'

#방향 결정
case = 4
for i in range(len(cctv)):
    case *= 4
case //= 4
for i in range(case):
    office2 = copy.deepcopy(office)
    brute = i
    for j in range(len(cctv)):
        dir = brute % 4
        brute //= 4
        x, y = cctv[j]
        if office[x][y] == 1:
            mark(x, y, dir)
        elif office[x][y] == 2:
            mark(x, y, dir)
            mark(x, y, dir+2)
        elif office[x][y] == 3:
            mark(x, y, dir)
            mark(x, y, dir+1)
        elif office[x][y] == 4:
            mark(x, y, dir)
            mark(x, y, dir+1)
            mark(x, y, dir+2)
        else:
            mark(x, y, dir)
            mark(x, y, dir+1)
            mark(x, y, dir+2)
            mark(x, y, dir+3)
    cnt = 0
    for p in range(N):
        for q in range(M):
            if office2[p][q] == 0:
                cnt += 1
    unseen = min(cnt, unseen)

print(unseen)