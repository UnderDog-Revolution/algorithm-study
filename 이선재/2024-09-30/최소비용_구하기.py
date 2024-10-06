from collections import deque
import sys
input = sys.stdin.readline
INF = int(1e9)

# n개의 도시, m개의 버스
n = int(input())
m = int(input())

# 버스 운행표[i] = (도착지, 비용)
arrival_cost_info = [[] for _ in range(n+1)]
total_cost = [INF] * (n+1)

# 버스의 출발 도시, 도착 도시, 비용
for i in range(m):
    dep, arv, cost = map(int, input().split())
    arrival_cost_info[dep].append((arv, cost))

# 출발점, 도착점
start, end = map(int, input().split())

total_cost[start] = 0
q = deque([(0, start)])

while q:
    current_cost, current_spot = q.pop()
    if total_cost[current_spot] < current_cost:
        continue
    else:
        # 현재 도시에서 갈 수 있는 지역과 비용의 정보
        for info in arrival_cost_info[current_spot]:
            mid_cost = current_cost + info[1]
            if total_cost[info[0]] > mid_cost:
                total_cost[info[0]] = mid_cost
                q.append((mid_cost, info[0]))

print(total_cost[end])