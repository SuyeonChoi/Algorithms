import sys
input = sys.stdin.readline
N = int(input())
A = sorted(list(map(int, input().split())))
M = int(input())
targets = list(map(int, input().split()))

def BinarySearch(target, length):
    st = 0
    en = length - 1
    while st <= en:
        mid = (st + en) // 2
        if A[mid] < target:
            st = mid+1
        elif A[mid] > target:
            en = mid - 1
        else:
            return 1
    return 0
for target in targets:
    if BinarySearch(target, len(A)):
        print(1)
    else:
        print(0)
