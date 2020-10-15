from itertools import combinations, permutations
import sys
input = sys.stdin.readline
N = int(input())
idx = [i for i in range(N)]
diff = []
ability = [list(map(int, input().split())) for _ in range(N)]
start = list(combinations(idx, N//2))
for i in range(len(start) // 2):
    link = [x for x in idx if x not in list(start[i])]
    start_ability = 0
    link_ability = 0
    for x, y in permutations(start[i], 2):
        start_ability += ability[x][y]
    for x, y in permutations(link, 2):
        link_ability += ability[x][y]
    diff.append(abs(link_ability-start_ability))
print(min(diff))
