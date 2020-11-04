import sys
input = sys.stdin.readline
def BinarySearch(target, length, A):
    st = 0
    en = length - 1
    while st <= en:
        mid = (st + en) // 2
        if A[mid] < target:
            st = mid + 1
        elif A[mid] > target:
            en = mid - 1
        else:
            return 1
    return 0

N = int(input())
card = sorted(list(map(int, input().split())))
M = int(input())
test = list(map(int, input().split()))

for target in test:
    if BinarySearch(target, len(card), card):
        print(1, end=' ')
    else:
        print(0, end=' ')
