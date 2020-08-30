import sys
input = sys.stdin.readline
test = int(input())
from collections import deque

def BinarySearch(queue, value):
    high = len(queue) - 1
    low = 0
    index = high
    while low <= high:
        mid = (low + high) // 2
        index = mid
        if queue[mid] > value:
            index = mid
            high = mid - 1
        else:
            low = mid + 1
            index = low
    return index



for i in range(test):
    k = int(input())
    Q = deque()
    D = dict()
    for j in range(k):
        command = list(map(str, input().split()))
        if command[0] == 'I':
            key = int(command[1])
            if key in D.keys():
                D[key] += 1
            else:
                D[key] = 1
                if Q:
                    idx = BinarySearch(Q, key)
                    Q.insert(idx, key)
                else:
                    Q.append(key)
        elif command[0] == 'D' and Q:
            if command[1] == '1':
                key = Q[len(Q)-1]
                if D[key] == 1:
                    del D[key]
                    Q.pop()
                else:
                    D[key] -= 1
            else:
                key = Q[0]
                if D[key] == 1:
                    del D[key]
                    Q.popleft()
                else:
                    D[key] -= 1

    if Q:
        print(Q[len(Q)-1], Q[0])
    else:
        print('EMPTY')
    # print(Q)
    # print(D)
