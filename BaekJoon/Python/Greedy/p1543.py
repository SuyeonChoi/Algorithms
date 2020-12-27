import sys
input = sys.stdin.readline
document = list(input())[:-1]
word = list(input())[:-1]
cur = 0
cnt = 0
while cur <= (len(document) - 1):
    isSame = 1
    tmp = cur
    for i in range(len(word)):
        if cur == len(document) or document[cur] != word[i]:
            isSame = 0
            break
        cur += 1
    if isSame:
        cnt += 1
    else:
        cur = tmp + 1

print(cnt)
