import sys
input = sys.stdin.readline

M = int(input())
N = int(input())
def isPrime(m, n):
    minPrime = 0
    primeSum = 0
    findMin = False
    for i in range(m, n+1):
        if i < 2:
            continue
        prime = True
        for j in range(2, i):
            if i % j == 0:
                prime = False
        if prime:
            primeSum += i
            if not findMin:
                minPrime = i
                findMin = True
    return minPrime, primeSum


_min, _sum = isPrime(M, N)
if _min == 0:
    print(-1)
else:
    print(_sum)
    print(_min)