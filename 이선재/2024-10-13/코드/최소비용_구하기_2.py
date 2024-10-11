from collections import deque
import sys
input = sys.stdin.readline
MAX = int(1e9)

def initialize_graph(n, m):
    # 버스 운행 정보[i] : i번쨰 도시에서 출발하는 버스의 정보 (도착지, 비용)
    bus_info = [[] for _ in range(n+1)]

    # m개 버스 정보 입력
    for i in range(m):
        dep, arv, cost = map(int, input().split())
        bus_info[dep].append((arv, cost))
    
    return bus_info


def initialize_cost(n, start):
    # 출발 도시에서 도착 도시까지의 최소 비용 저장
    min_cost = [MAX] * (n+1)
    min_cost[start] = 0

    return min_cost


def dijkstra(n, start, end, bus_info):
    total_cost = initialize_cost(n, start)
    q = deque([(0, start)])
    previous = [0] * (n+1)

    while q:
        current_cost, current_spot = q.pop()

        # 이미 더 짧은 경로가 존재한다면 스킵
        if total_cost[current_spot] < current_cost:
            continue

        # 인접한 모든 노드를 탐색
        for next_spot, travel_cost in bus_info[current_spot]:
            mid_cost = current_cost + travel_cost

            # 더 짧은 경로로 이동할 수 있다면 갱신하고 큐에 추가
            if mid_cost < total_cost[next_spot]:
                total_cost[next_spot] = mid_cost
                previous[next_spot] = current_spot
                q.append((mid_cost, next_spot))

    # 최소 비용 경로에 포함된 도시 개수와 경로 구하기
    path = [end]
    tmp = end
    while tmp != start:
        tmp = previous[tmp]
        path.append(tmp)
    path.reverse()

    result_cost = total_cost[end]
    result_path_len = len(path)
    result_path = path

    return result_cost, result_path_len, result_path

    
def main():
    # n개의 도시, m개의 버스
    n = int(input())
    m = int(input())

    # 유효성 검사
    if n <= 0 or m < 0:
        print("wrong info")
    
    bus_info = initialize_graph(n, m)

    # 구하고자 하는 구간 정보
    start, end = map(int, input().split())

    # 유효성 검사
    if not(1 <= start <= n) or not(1<= end <= n):
        print("wrong info")
        return
    
    # 예외 처리
    if start == end:
        print(0)
        return
    
    # 다익스트라
    result1, result2, result3 = dijkstra(n, start, end, bus_info)

    # 결과 출력
    if result1 == MAX:
        print(f"no path for {start} to {end}")
    else:
        print(result1)
        print(result2)
        for i in result3:
            print(i, end = ' ')


if __name__ == "__main__":
    main()