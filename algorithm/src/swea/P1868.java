package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class P1868 {
	static int min;
	static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

	static void bfs(char board[][], int n) {
		Queue<int[]> queue = new ArrayDeque<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int cnt = 0;
				for (int k = 0; k < 8; k++) {
					if (isPossible(i + dx[k], j + dy[k], n) && board[i + dx[k]][j + dy[k]] == '*') {
						cnt++;
					}
				}

				board[i][j] = (char) ('0' + cnt);
			}
		}
	}

	static boolean isPossible(int x, int y, int n) {
		if (x >= 0 && x < n && y >= 0 && y < n) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());

			char[][] board = new char[n][n];

			for (int i = 0; i < n; i++) {
				String str = br.readLine();

				for (int j = 0; j < n; j++) {
					board[i][j] = str.charAt(j);
				}
			}

			min = Integer.MAX_VALUE;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (board[i][j] != '*') {
						bfs(board, n);
					}
				}
			}

			sb.append("#").append(tc).append(" ").append(false).append("\n");
		}

		System.out.println(sb.toString());
	}
}
