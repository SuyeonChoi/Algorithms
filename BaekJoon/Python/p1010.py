import math

case = int(input())

for i in range(case):
    N, M = map(int, input().split())
    print(int(math.factorial(M)/(math.factorial(N)*math.factorial(M-N))))
