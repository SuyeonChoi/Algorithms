from operator import itemgetter

def solution(n, delivery):
    stock = ['?']*n
    delivery.sort(key=itemgetter(2), reverse=True)
    for first, sec, delivered in delivery:
        first -= 1
        sec -= 1
        if delivered == 1:
            stock[first] = 'O'
            stock[sec] = 'O'
        elif delivered == 0:
            if stock[first] == 'O':
                stock[sec] = 'X'
            elif stock[sec] == 'O':
                stock[first] = 'X'
    answer = ''.join(stock)
    return answer

print(solution(6, 	[[1,3,1],[3,5,0],[5,4,0],[2,5,0]]))