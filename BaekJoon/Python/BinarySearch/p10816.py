import sys
input = sys.stdin.readline
def lower_idx(target, length, cards):
    st = 0
    en = length
    while st < en:
        mid = (st + en) // 2
        if cards[mid] >= target:
            en = mid
        else:
            st = mid + 1
    return st

def upper_idx(target, length, cards):
    st = 0
    en = length
    while st < en:
        mid = (st + en) // 2
        if cards[mid] > target:
            en = mid
        else:
            st = mid + 1
    return st

N = int(input())
cards = sorted(list(map(int, input().split())))
M = int(input())
test = list(map(int, input().split()))
for t in test:
    l = lower_idx(t, len(cards), cards)
    u = upper_idx(t, len(cards), cards)
    print(u-l, end=' ')

