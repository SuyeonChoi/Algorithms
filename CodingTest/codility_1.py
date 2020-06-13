def solution(A):
    N = len(A)
    M = len(A[0])
    equilibrium = 0
    upper_P = 0
    lower_P = 0
    for i in range(N):
        lower_P += sum(A[i])
    right_q = 0
    for i in range(1, M):
        for j in range(N):
            right_q += A[j][i]

    for P in range(N):
        if P > 0:
            upper_P += sum(A[P-1])
        lower_P -= sum(A[P])
        left_Q = 0
        right_Q = right_q
        for Q in range(M):
            if Q > 0:
                delete_right = 0
                add_left = 0
                for i in range(N):
                    delete_right += A[i][Q]
                    add_left += A[i][Q-1]
                right_Q -= delete_right
                left_Q += add_left
            if(left_Q == right_Q and lower_P == upper_P):
                equilibrium += 1
    return equilibrium
    # pass

A =  [[2, 7, 5],[3, 1, 1],[2, 1, -7], [0, 2, 1],[1, 6, 8]]
print(solution(A))
