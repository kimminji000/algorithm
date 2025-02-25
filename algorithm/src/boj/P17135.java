package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P17135 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		int[][] grid = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < m - 2; i++) {
			for (int j = i; j < m - 1; j++) {
				for (int k = j; k < m; k++) {
					for (int row = n - 1; row >= 0; row--) {
						for (int col = 0; col < m; m++) {
							
						}
					}
				}
			}
		}


		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
