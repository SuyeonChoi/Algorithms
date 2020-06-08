test_case = int(input())
for i in range(test_case):
    N = int(input())
    zero = 0
    one = 1
    fibbo = [[0]*2 for k in range(N+1)]
    for j in range(N+1):
        if j  == 0:
            fibbo[0] = [1, 0]
        elif j == 1:
            fibbo[1] = [0, 1]
        else:
            fibbo[j][0] = fibbo[j-1][0] + fibbo[j-2][0]
            fibbo[j][1] = fibbo[j-1][1] + fibbo[j-2][1]
    print(fibbo[N][0], fibbo[N][1])
