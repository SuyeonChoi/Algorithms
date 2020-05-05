quitDay = int(input())
T = []
P = []
V = [0 for i in range(quitDay+1)]

for i in range(quitDay):
    t, p = map(int, input().split())
    T.append(t)
    P.append(p)

for i in range(quitDay):
    for j in range(i+T[i], quitDay+1):
        V[j] = max(V[j], V[i]+P[i])

print(V[quitDay])