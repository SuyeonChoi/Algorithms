import sys
input = sys.stdin.readline
def isPrime(M, N):
    state = [True] * (N + 1)
    state[1] = False
    ret = []
    for i in range(1, N + 1):
        if i * i > N:
            break
        if not state[i]:
            continue
        for j in range(i * i, N + 1, i):
            if j > N:
                break
            state[j] = False
    for i in range(M, len(state)):
        if state[i]:
            ret.append(i)
    return ret

M = int(input())
N = int(input())
primes = isPrime(M, N)
if primes:
    print(sum(primes))
    print(primes[0])
else:
    print(-1)