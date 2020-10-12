import sys
input = sys.stdin.readline
N = int(input())
dimension = dict()
for i in range(N):
    x, y = map(int, input().split())
    if x in dimension:
        dimension[x].append(y)
    else:
        dimension[x] = [y]

dimension = sorted(dimension.items())
for i in range(len(dimension)):
    x = dimension[i][0]
    y_list = sorted(dimension[i][1])
    for y in y_list:
        print(x, y)