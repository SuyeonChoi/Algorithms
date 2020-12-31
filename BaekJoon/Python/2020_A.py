def wordChain(words):
    w = list(words[0])[0]
    for word in words:
        tmp = list(word)
        if tmp[0] != w:
            return 0
    return 1

N = int(input())

words = list(map(str, input().split()))

print(wordChain(words))
