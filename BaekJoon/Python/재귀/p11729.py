N = int(input())

def hanoi(a, b, n):
    #a: 시작 위치
    #b: 이동 위치
    #n: 옮길 원판 개수
    #base condition
    if n == 1:
        print(a, b)
    else:
        #n-1개를 이동
        hanoi(a, 6-a-b, n-1)
        #n번째 원판을 이동
        print(a, b)
        #다시 n-1개를 b로 이동
        hanoi(6-a-b, b, n-1)

print(2**N-1)
hanoi(1, 3, N)
