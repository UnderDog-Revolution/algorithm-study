package baekJoon.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q7576 {

    public static class Point{
        int x;
        int y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        // 입력
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] board = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                board[i][j] = sc.nextInt();
            }
        }

        // bfs에서 사용할 큐
        Queue<Point> q = new LinkedList<>();

        //상하좌우로 이동을 편리하기 위한 변수
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        int[][] distance = new int[n][m]; // 토마토 익는 최소 일 수 저장
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                distance[i][j] = -1; // 방문 여부를 표시하는 방식으로 -1로 초기화

        // 모든 익은 토마토를 큐에 추가하고 시작 지점으로 설정
        for(int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (board[y][x] == 1) {
                    q.add(new Point(x, y));
                    distance[y][x] = 0; // 익은 토마토의 초기 거리 설정
                }
            }
        }

        while (!q.isEmpty()) {
            Point originPoint = q.poll();

            // 상하좌우로 이동
            for (int i = 0; i < 4; i++) {
                int moveX = originPoint.x + dx[i];
                int moveY = originPoint.y + dy[i];

                // 범위를 벗어나거나 빈공간(-1)일 경우 무시
                if (moveX < 0 || moveX >= m || moveY < 0 || moveY >= n || board[moveY][moveX] == -1)
                    continue;

                // 익지 않은 토마토(0)만 방문, 거리 갱신
                if (board[moveY][moveX] == 0 && distance[moveY][moveX] == -1) {
                    distance[moveY][moveX] = distance[originPoint.y][originPoint.x] + 1;
                    q.add(new Point(moveX, moveY));
                }
            }
        }

        // 최대 거리 계산 및 출력
        int maxDistance = -1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                // 익지 않은 토마토가 있을 경우 -1 출력
                if (distance[i][j] == -1) {
                    System.out.println(-1);
                    return;
                }
                // 최대 거리 계산
                maxDistance = Math.max(maxDistance, distance[i][j]);
            }
        }
        // 최대 거리 출력
        System.out.println(maxDistance);
    }
}
