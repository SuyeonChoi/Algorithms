from collections import Counter
T = int(input())
for i in range(T):
    idx = int(input())
    arr = list(map(int, input().split()))
    score = Counter(arr).most_common(1)[0][0]
    print('#', end='')
    print(idx, score)
