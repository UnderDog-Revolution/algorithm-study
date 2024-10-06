package algorithm;

import java.util.*;

public class Bj_3085 {
    static int n;
    static char[][] board;

    static int getMaxCandies() {
        int maxCandies = 1;
        for (int i = 0; i < n; i++) {
            int rowCount = 1;
            for (int j = 1; j < n; j++) {
                if (board[i][j] == board[i][j - 1]) {
                    rowCount++;
                } else {
                    rowCount = 1;
                }
                maxCandies = Math.max(maxCandies, rowCount);
            }
        }

        for (int j = 0; j < n; j++) {
            int colCount = 1;
            for (int i = 1; i < n; i++) {
                if (board[i][j] == board[i - 1][j]) {
                    colCount++;
                } else {
                    colCount = 1;
                }
                maxCandies = Math.max(maxCandies, colCount);
            }
        }
        return maxCandies;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        board = new char[n][n];

        for (int i = 0; i < n; i++) {
            String row = scanner.next();
            board[i] = row.toCharArray();
        }

        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j + 1 < n) {
                    char temp = board[i][j];
                    board[i][j] = board[i][j + 1];
                    board[i][j + 1] = temp;

                    result = Math.max(result, getMaxCandies());

                    temp = board[i][j];
                    board[i][j] = board[i][j + 1];
                    board[i][j + 1] = temp;
                }

                if (i + 1 < n) {
                    char temp = board[i][j];
                    board[i][j] = board[i + 1][j];
                    board[i + 1][j] = temp;

                    result = Math.max(result, getMaxCandies());

                    temp = board[i][j];
                    board[i][j] = board[i + 1][j];
                    board[i + 1][j] = temp;
                }
            }
        }

        System.out.println(result);
    }
}
