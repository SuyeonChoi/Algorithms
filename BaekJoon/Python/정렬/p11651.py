import sys
input = sys.stdin.readline
N = int(input())
dimen = dict()
for i in range(N):
    x, y = map(int, input().split())
    if y in dimen:
        dimen[y].append(x)
    else:
        dimen[y] = [x]

dimen = sorted(dimen.items())
for i in range(len(dimen)):
    y = dimen[i][0]
    x_list = sorted(dimen[i][1])
    for x in x_list:
        print(x, y)
