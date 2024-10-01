from collections import deque

n = int(input())
m = int(input())

# 버스 운행표
bus_time = [[0] * (n+1) for i in range(n+1)]
possible_cost = []

for i in range(m):
    departure, arrival, cost = map(int, input().split())
    bus_time[departure][arrival] = cost

path = deque([1])
