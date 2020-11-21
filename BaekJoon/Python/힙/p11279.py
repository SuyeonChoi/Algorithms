import heapq
import sys
input = sys.stdin.readline
N = int(input())
heap = []
for i in range(N):
    opr = int(input())
    if opr == 0:
        if heap:
            print(heapq.heappop(heap)[1])
        else:
            print(0)
    else:
        heapq.heappush(heap, (-opr, opr))