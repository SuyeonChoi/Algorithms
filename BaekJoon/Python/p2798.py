#N = 카드개수
#M = 목표 숫자
N, M = map(int, input().split())

cards = list(map(int, input().split()))
sum = 0
max = 0

for i in range(len(cards)-2):
    for j in range(i+1, len(cards)-1):
        for k in range(j+1, len(cards)):
            sum = cards[i]+cards[j]+cards[k]
            if(max<sum and sum<=M):
                max = sum;

print(max)
