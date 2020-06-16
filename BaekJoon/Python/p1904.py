N = int(input())
count = 0

tiles = [0, 1, 2]
if N > 2:
    for i in range(3, N+1):
        tiles.append(tiles[i-1] + tiles[i-2])
print(tiles[N]%15746)
