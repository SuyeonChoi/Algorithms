import sys
input = sys.stdin.readline
T = int(input())
waveSeq = [0] * 101
for i in range(101):
    if i <= 3:
        waveSeq[i] = 1
    elif i <= 5:
        waveSeq[i] = 2
    else:
        waveSeq[i] = waveSeq[i-1] + waveSeq[i-5]
for i in range(T):
    print(waveSeq[int(input())])