def solution(phone_book):
    answer = True
    phone_book = sorted(phone_book)
    for a in range(1, len(phone_book)):
        i = phone_book[a]
        for b in (0, a-1):
            j = phone_book[b]
            if len(j) <= len(i) and (i[:len(j)] == j):
                return False
    return answer

