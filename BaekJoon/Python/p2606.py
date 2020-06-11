num = int(input())
connections = int(input())
network = dict()
for i in range(1, num+1):
    network[i] = list()

for i in range(connections):
    a, b = map(int, input().split())
    network.get(a).append(b)
    network.get(b).append(a)

infected = list()

def get_infection(computers):
    global infected
    global network
    for i in range(len(computers)):
        if computers[i] not in infected:
            infected.append(computers[i])
            get_infection(network.get(computers[i]))

get_infection(network.get(1))
print(len(infected)-1)
